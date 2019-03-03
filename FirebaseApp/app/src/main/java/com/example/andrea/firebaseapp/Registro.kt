package com.example.andrea.firebaseapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_registro.*

class Registro : AppCompatActivity() {
    /*companion object {
        val IMAGE_PERFIL_CODE =1234
        var urlFoto : String = ""
    }*/

    lateinit var storageDb: FirebaseStorage
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        val auth= FirebaseAuth.getInstance()
        val database= FirebaseDatabase.getInstance()
        val dbReference= database.reference
        storageDb = FirebaseStorage.getInstance()
        //--------------------------------------------------------------------------------------------------------------------
        //img_perfil.setOnClickListener(){
            //val intent = Intent()
            //intent.action = Intent.ACTION_GET_CONTENT
            //intent.type = "image/*"
          //  intent.putExtra( Intent.EXTRA_LOCAL_ONLY,true)
        //    startActivityForResult(intent, IMAGE_PERFIL_CODE)

        //--------------------------------------------------------------------------------------------------------------------
        bt_registro.setOnClickListener(){
            auth.createUserWithEmailAndPassword(et_rg_correo.text.toString(),et_rg_contra.text.toString()).addOnCompleteListener(this){
                task ->
                if(!task.isSuccessful){
                        Toast.makeText(this,"Fallo el registro de usuario :(",Toast.LENGTH_SHORT).show()
                        Log.w("CrateAccountActivity", "createUserWithEmail:failure", task.exception)
                }else{
                        Toast.makeText(this,"Cuenta creada con éxito (:", Toast.LENGTH_SHORT).show()

                        val userActual = auth.currentUser
                        val userUID= userActual?.uid
                        //Toast.makeText(this,userActual?.uid,Toast.LENGTH_SHORT).show()
                        //Si solo mandamos el nombre
                        val parent= dbReference.child("Users").child(userUID.toString()).setValue(name.text.toString())
                        //dbReference.child("Users").child(userUID).setValue(datosUsuario)
                        userActual?.sendEmailVerification()?.addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Se ha enviado un correo de validacion (:", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Fallo el envio de correo de validacion :(", Toast.LENGTH_SHORT).show()
                            Log.w("CrateAccountActivity", "sendEmai:failure", task.exception)
                        }
                    }

                }
            }

        }
        //----------------------------------------------------------------------------------------------------------------------
    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (Activity.RESULT_OK == resultCode) {
            if (IMAGE_PERFIL_CODE == requestCode) {
                val imagenUri = data?.data
                img_perfil.setImageURI(imagenUri)
                val storageReference = storageDb.getReference("imagenes_perfil")
                val imagenReferencia = storageReference.child(imagenUri!!.lastPathSegment)
                imagenReferencia.putFile(imagenUri).addOnSuccessListener {
                    taskSnapshot ->
                    val uri = taskSnapshot.downloadUrl
                    urlFoto = uri.toString()
                    Toast.makeText(this,urlFoto,Toast.LENGTH_SHORT).show()

                }
            }

        }
    }*/
}
