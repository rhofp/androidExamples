package com.example.rho.ebook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var personas : ArrayList<Persona>? = null

    var lista:RecyclerView? = null

    var layoutManager: RecyclerView.LayoutManager? = null

    var adaptador :AdaptadorCustom?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personas = ArrayList()
        personas?.add(Persona("DeathPool",R.drawable.deathpool))
        personas?.add(Persona("Ironman",R.drawable.ironman))
        personas?.add(Persona("Spiderman",R.drawable.spidi))
        personas?.add(Persona("Capitan America",R.drawable.capitan))
        personas?.add(Persona("Black panther",R.drawable.blackpanther))
        personas?.add(Persona("Wolverine",R.drawable.wolverine))

        lista = findViewById(R.id.lista)

        layoutManager = LinearLayoutManager(this)

        adaptador = AdaptadorCustom(personas!!,object :ClickListener{
            override fun onClick(view: View, posicion: Int) {
                Toast.makeText(applicationContext,personas?.get(posicion)?.nombre, Toast.LENGTH_SHORT).show()
            }
        })

        lista?.layoutManager = layoutManager

        lista?.adapter = this.adaptador

    }
}
