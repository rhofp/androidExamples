package com.example.andrea.firebaseapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val auth= FirebaseAuth.getInstance()
        entrar.setOnClickListener(){
            auth.signInWithEmailAndPassword(mail.text.toString(),password.text.toString()).addOnCompleteListener(this){
                task ->
                if(!task.isSuccessful){
                    Toast.makeText(this,"Datos erroneos :(", Toast.LENGTH_SHORT).show()

                }else{
                    val intent = Intent(this,ActividadChat::class.java)
                    startActivity(intent)
                }
            }
        }
        registrarse.setOnClickListener(){
            val intent= Intent(this,Registro::class.java)
            startActivity(intent)
        }

        forgotpass.setOnClickListener(){
            val intent= Intent(this, Password::class.java)
            startActivity(intent)
        }
    }
}
