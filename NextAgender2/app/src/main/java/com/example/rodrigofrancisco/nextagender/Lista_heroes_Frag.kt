package com.example.rodrigofrancisco.nextagender


import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.example.rho.ebook.AdaptadorCustom
import com.example.rho.ebook.ClickListener
import kotlinx.android.synthetic.main.fragment_lista_heroes_.*


class Lista_heroes_Frag : Fragment() {

    var twoPane: Boolean = false

    var comunicador: Comunicador? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (activity?.resources?.configuration?.orientation == Configuration.ORIENTATION_LANDSCAPE)
            twoPane = true

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_heroes_, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var mis_heroes = cargarHeroes()

        comunicador = activity as Comunicador

        rv_heroes.layoutManager = LinearLayoutManager(activity?.applicationContext)

        rv_heroes.adapter = AdaptadorCustom(mis_heroes,object : ClickListener{
            override fun onClick(view: View, posicion: Int) {
                if (twoPane){
                    comunicador?.responder(mis_heroes.get(posicion))
                }else
                    Toast.makeText(activity?.applicationContext,mis_heroes.get(posicion).nombre,Toast.LENGTH_SHORT).show()
            }
        })

    }

    fun cargarHeroes(): ArrayList<Heroe>{
        var heroes: ArrayList<Heroe> = ArrayList()

        heroes.add(Heroe("DeathPool",R.drawable.deathpool,"Regeneracion","Wade Wilson"))
        heroes.add(Heroe("IronMan",R.drawable.ironman,"Ser rico","Tony Stark"))
        heroes.add(Heroe("Spiderman",R.drawable.spidi,"Sentido aracnido","Peter Parker"))
        heroes.add(Heroe("Capitan America",R.drawable.capitan,"Superfuerza","Setve Rogers"))
        heroes.add(Heroe("Black Panther",R.drawable.blackpanther,"Su traje","Es de Wakanda"))
        heroes.add(Heroe("Wolverine",R.drawable.wolverine,"Regeneracion","Logan"))

        return heroes
    }



}
