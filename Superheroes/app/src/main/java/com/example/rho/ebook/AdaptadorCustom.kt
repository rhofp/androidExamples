package com.example.rho.ebook

import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.template.view.*

class AdaptadorCustom(items:ArrayList<Persona>, var clickListener: ClickListener): RecyclerView.Adapter<AdaptadorCustom.ViewHolder>() {

    var items: ArrayList<Persona>? = null

    var viewHolder: ViewHolder? = null

    init {
        this.items = items
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorCustom.ViewHolder {
        val vista = LayoutInflater.from(p0.context).inflate(R.layout.template,p0,false)

        viewHolder = ViewHolder(vista,clickListener)

        return viewHolder as ViewHolder
    }

    override fun getItemCount(): Int {
        return this.items?.count()!!
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val item = items?.get(p1)
        p0.nombre?.text = item?.nombre
        p0.foto?.setImageResource(item?.foto!!)
    }

    class ViewHolder(vista:View, listener: ClickListener): RecyclerView.ViewHolder(vista), View.OnClickListener {

        var listener: ClickListener? = null
        var vista = vista

        var foto: ImageView? = null
        var nombre: TextView? = null

        init {
            this.foto = vista.ivfoto
            this.nombre = vista.tvNombre
            this.listener = listener

            vista.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            this.listener?.onClick(v!!,adapterPosition)
        }
    }

}