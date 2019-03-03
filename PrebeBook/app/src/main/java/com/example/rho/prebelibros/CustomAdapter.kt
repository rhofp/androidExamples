package com.example.rho.prebelibros

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CustomAdapter(val capsList: ArrayList<Capitulos>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bindItems(capsList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return capsList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(caps: Capitulos) {
            val textViewName = itemView.findViewById(R.id.tv_numCap) as TextView
            val textViewAddress  = itemView.findViewById(R.id.tv_tituloCap) as TextView
            textViewName.text = caps.num
            textViewAddress.text = caps.titulo
        }
    }
}