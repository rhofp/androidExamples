package com.example.octav.layouts

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_evento.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var contador:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evento)

        button.setOnClickListener{
            view -> sumarContador(view)
        }






    }

    fun sumarContador(view: View){
        contador++
        mostrarResultado(view)
    }

    fun mostrarResultado(view: View){
        var resultado = findViewById(R.id.textView) as TextView

        resultado.setText("Contador: $contador")
    }



}
