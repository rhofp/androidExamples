package com.androikrf.rho.nextagender


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.rho.heroes.Heroe

class Contenido_heroesFrag : Fragment() {

    var nombre_heroe: TextView? =null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_contenido_heroes, container, false)

        nombre_heroe = vista.findViewById<TextView>(R.id.tv_nombre_heroe)

        return vista
    }

    fun cargarDatos(heroe: Heroe){
        //nombre_heroe?.text = heroe.nombre
        nombre_heroe?.text = "Rodrigo"
    }




}
