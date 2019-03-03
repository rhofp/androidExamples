package com.example.rodrigofrancisco.nextagender


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_descripcion_heroe.*


class Descripcion_heroeFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_descripcion_heroe, container, false)
    }

    fun cargarDescripcion(heroe: Heroe){
        superfoto.setImageResource(heroe.foto)
        supernombre.text = heroe.nombre
        superpoder.text = heroe.superpoder
        superidentidad.text = heroe.identidad
    }


}
