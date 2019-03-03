package com.example.rho.heroes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var miSuperheroes = crearSuperHeroes()

        lista.layoutManager = LinearLayoutManager(this)

        lista.adapter = AdaptadorCustom(miSuperheroes,object :ClickListener{
            override fun onClick(view: View, posicion: Int) {
                Toast.makeText(applicationContext,miSuperheroes.get(posicion)?.nombre, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun crearSuperHeroes(): ArrayList<Heroe>{
        var heroes: ArrayList<Heroe>? = null
        heroes = ArrayList()

        heroes?.add(Heroe("Deathpool",R.drawable.deathpool))
        heroes?.add(Heroe("IronMan",R.drawable.ironman))
        heroes?.add(Heroe("Spiderman",R.drawable.spidi))
        heroes?.add(Heroe("Capitan America",R.drawable.capitan))
        heroes?.add(Heroe("black Phanter",R.drawable.blackpanther))
        heroes?.add(Heroe("Wolverine",R.drawable.wolverine))

        return heroes
    }
}
