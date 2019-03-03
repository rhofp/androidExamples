package com.example.rho.heroes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.heroes_item.view.*

class AdaptadorCustom(items:ArrayList<Heroe>, var clickListener: ClickListener): RecyclerView.Adapter<AdaptadorCustom.ViewHolder>() {

    var items: ArrayList<Heroe>?=null
    var viewHolder: ViewHolder?=null

    init {
        this.items = items
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorCustom.ViewHolder {
        val vista = LayoutInflater.from(p0.context).inflate(R.layout.heroes_item,p0,false)

        viewHolder = ViewHolder(vista,clickListener)

        return viewHolder as ViewHolder
    }

    override fun getItemCount(): Int {
        return this.items?.count()!!
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val items = items?.get(p1)
        p0.nombre?.text = items?.nombre
        p0.foto?.setImageResource(items?.foto!!)
    }

    class ViewHolder(vista:View, listener: ClickListener): RecyclerView.ViewHolder(vista), View.OnClickListener {

        var listener: ClickListener? = null
        var vista = vista

        var foto: ImageView? = null
        var nombre: TextView? = null

        init {
            this.foto = vista.iv_foto
            this.nombre = vista.tv_nombre
            this.listener = listener

            vista.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            this.listener?.onClick(v!!,adapterPosition)
        }
    }
}