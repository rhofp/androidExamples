package com.androikrf.rho.nextagender


import android.content.res.Configuration
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rho.heroes.AdaptadorCustom
import com.example.rho.heroes.ClickListener
import com.example.rho.heroes.Heroe
import kotlinx.android.synthetic.main.fragment_lista_heroes.*

class Lista_heroesFrag : Fragment() {

    var twopane :Boolean =  false

    var comunicador: Comunicador? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if(activity?.resources?.configuration?.orientation == Configuration.ORIENTATION_LANDSCAPE)
            twopane = true

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_heroes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        comunicador = activity as Comunicador

        var miSuperheroes = crearSuperHeroes()

        rv_heroes.layoutManager = LinearLayoutManager(activity?.applicationContext)

        rv_heroes.adapter = AdaptadorCustom(miSuperheroes,object : ClickListener {
            override fun onClick(view: View, posicion: Int) {
                if (twopane) {
                    comunicador?.responder(miSuperheroes.get(posicion))
                }else{
                    activity?.reemplazarFragment(
                        Contenido_heroesFrag(),
                        true,
                        R.id.fr_lista_heroes
                    )
                    //comunicador?.responder(miSuperheroes.get(posicion))

                }

            }
        })

    }

    fun crearSuperHeroes(): ArrayList<Heroe>{
        var heroes: ArrayList<Heroe>? = ArrayList()

        heroes?.add(Heroe("Deathpool",R.drawable.deathpool))
        heroes?.add(Heroe("IronMan",R.drawable.ironman))
        heroes?.add(Heroe("Spiderman",R.drawable.spidi))
        heroes?.add(Heroe("Capitan America",R.drawable.capitan))
        heroes?.add(Heroe("black Phanter",R.drawable.blackpanther))
        heroes?.add(Heroe("Wolverine",R.drawable.wolverine))

        return heroes!!
    }

}

fun FragmentActivity.reemplazarFragment(
    fragment: Fragment,
    allowStateLoss: Boolean = false,
    @IdRes contenedor: Int
) {
    val ft = supportFragmentManager.beginTransaction()

    val reemplazar = ft.replace(contenedor,fragment)
    if (!supportFragmentManager.isStateSaved) {
        reemplazar.addToBackStack(null)
        reemplazar.commit()
    } else {
        reemplazar.commitAllowingStateLoss()
    }
}