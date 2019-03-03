package com.example.andrea.firebaseapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_password.*

class Password : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
        val auth= FirebaseAuth.getInstance()
        bt_continue.setOnClickListener(){
            if(!mail.text.toString().isEmpty()){
                auth.sendPasswordResetEmail(mail.text.toString()).addOnCompleteListener(){
                    task ->
                    if(!task.isSuccessful){
                        Toast.makeText(this,"No hay un usuario registrado con ese correo :(",Toast.LENGTH_SHORT).show()
                        Log.w("CrateAccountActivity", "recuperaPassword", task.exception)
                    }else{
                        Toast.makeText(this,"Se ha enviado la contraseña a tu correo", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this,"Introduce el correo >:(",Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun volver(){
        val intent= Intent(this@Password,MainActivity::class.java)
        startActivity(intent)
    }
}
