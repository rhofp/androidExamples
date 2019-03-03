package com.example.rho.heroes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var heroes: ArrayList<Heroe>? = null

    var lista: RecyclerView? = null

    var layoutManager: RecyclerView.LayoutManager? = null

    var adaptador: AdaptadorCustom? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heroes = ArrayList()

        heroes?.add(Heroe("Deathpool",R.drawable.deathpool,"regeneración"))
        heroes?.add(Heroe("IronMan",R.drawable.ironman,"Su traje"))
        heroes?.add(Heroe("Spiderman",R.drawable.spidi,"Telarañas"))
        heroes?.add(Heroe("Capitan America",R.drawable.capitan,"Escudo"))
        heroes?.add(Heroe("black Phanter",R.drawable.blackpanther,"Traje"))
        heroes?.add(Heroe("Wolverine",R.drawable.wolverine,"Garras "))

        lista= findViewById(R.id.lista)

       // layoutManager = LinearLayoutManager(this)

        /*adaptador = AdaptadorCustom(heroes!!,object : ClickListener{
            override fun onClick(view: View, posicion: Int) {
                Toast.makeText(applicationContext,heroes?.get(posicion)?.nombre,Toast.LENGTH_SHORT).show()
            }

        })*/

        //lista?.layoutManager = layoutManager

        lista?.layoutManager = LinearLayoutManager(this)

        //lista?.adapter = this.adaptador
        lista?.adapter = AdaptadorCustom(heroes!!,object : ClickListener{
            override fun onClick(view: View, posicion: Int) {
                Toast.makeText(applicationContext,heroes?.get(posicion)?.nombre,Toast.LENGTH_SHORT).show()
            }

        })
    }
}
