package com.example.andrea.firebaseapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.cv_mensajes.view.*


class AdapterMensajes(private val lista_mensajes : ArrayList<Mensaje>, c: Context) : RecyclerView.Adapter<HolderMensaje>(){
    var context = c

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderMensaje {
        return HolderMensaje(LayoutInflater.from(parent.context).inflate(R.layout.cv_mensajes,parent,false))
    }

    override fun getItemCount(): Int {
        return lista_mensajes.size
    }

    override fun onBindViewHolder(holder: HolderMensaje, position: Int) {
        holder.itemView.nombreMensaje.text = lista_mensajes.get(position).nombre
        holder.itemView.mensajeMensaje.text = lista_mensajes.get(position).mensaje
        if(lista_mensajes.get(position).tipo.equals("1")){
            holder.itemView.mensajeMensaje.visibility= View.VISIBLE
            holder.itemView.mensajeFoto.visibility= View.GONE

        }else{
            holder.itemView.mensajeMensaje.visibility= View.VISIBLE
            holder.itemView.mensajeFoto.visibility= View.VISIBLE
            Glide.with(context).load(lista_mensajes.get(position).urlFoto).into(holder.itemView.mensajeFoto)
        }


    }



}