package com.example.andrea.firebaseapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.andrea.firebaseapp.R.id.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_actividad_chat.*


class ActividadChat : AppCompatActivity() {
    companion object {
        val IMAGE_CODE = 123
    }
    lateinit var storageDb: FirebaseStorage
    lateinit var nomUser: String
    lateinit var baseChat: DatabaseReference
    lateinit var adapter : AdapterMensajes
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_chat)
        //--------------------------------------------------Recupera el nombre de la base y lo pone en el TextView
        val auth = FirebaseAuth.getInstance()
        val dbReference = FirebaseDatabase.getInstance().getReference("Users").child(auth.currentUser?.uid)
        storageDb = FirebaseStorage.getInstance()
        dbReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
                println("Something went wrong when retrieving data!")
            }

            override fun onDataChange(p0: DataSnapshot?) {
                nomUser = p0!!.value.toString()
                nombre.setText(p0!!.value.toString())

            }
        })
        //
        //-----------------------------------------------------------------------------------------------------------

        val mensajes = ArrayList<Mensaje>()
        adapter = AdapterMensajes(mensajes,this)
        val llm = LinearLayoutManager(this)
        //rvMensajes.layoutManager
        rvMensajes.layoutManager = llm
        rvMensajes.adapter = adapter
        baseChat = FirebaseDatabase.getInstance().reference
        btnEnviar.setOnClickListener() {
            val new_msj = Mensaje(txtMensaje.text.toString(), nomUser, "00:00", "", "1")
            /*mensajes.add(new_msj)
            Toast.makeText(this, mensajes.get(mensajes.size-1).mensaje,Toast.LENGTH_LONG).show()
            adapter.notifyDataSetChanged()*/
            //val key = baseChat.child("Chat").push().key
            //baseChat.child("Chat").child(key).setValue(new_msj)
            baseChat.child("Chat").push().setValue(new_msj)
            txtMensaje.setText("")

        }

        btnEnviarFoto.setOnClickListener() {
            val intent = Intent()
            intent.action = Intent.ACTION_GET_CONTENT
            intent.type = "image/*"
            intent.putExtra( Intent.EXTRA_LOCAL_ONLY,true)
            startActivityForResult(intent, IMAGE_CODE)
        }


        val childEvent = object : ChildEventListener {
            override fun onChildAdded(p0: DataSnapshot?, p1: String?) {
                val mensaje = p0?.getValue(Mensaje::class.java)
                mensajes.add(mensaje!!)
                adapter.notifyDataSetChanged()

            }

            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildChanged(p0: DataSnapshot?, p1: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

            }

            override fun onChildMoved(p0: DataSnapshot?, p1: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildRemoved(p0: DataSnapshot?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }
        baseChat.child("Chat").addChildEventListener(childEvent)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (Activity.RESULT_OK == resultCode) {
            if (IMAGE_CODE == requestCode) {
                val imagenUri = data?.data
                val storageReference = storageDb.getReference("imagenes_chat")
                val fotoReferencia = storageReference.child(imagenUri!!.lastPathSegment)
                fotoReferencia.putFile(imagenUri).addOnSuccessListener {
                    taskSnapshot ->
                    val uri = taskSnapshot.downloadUrl
                    val msj = Mensaje(nomUser+" te ha enviado una foto",uri.toString(),nomUser,"00:00","","2")
                    baseChat.child("Chat").push().setValue(msj)

                }
            }

        }
    }
}




