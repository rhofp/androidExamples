package com.example.sistemas.listviewofficial2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(var context: Context, var artist: ArrayList<Artist>): BaseAdapter(){

    private class ViewHolder(row: View?){
        var txtName: TextView
        var ivImagen: ImageView
        init {
            this.txtName = row?.findViewById(R.id.txtArtista) as TextView
            this.ivImagen = row?.findViewById(R.id.ivArtista) as ImageView
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if(convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.artist_item_list,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var artist: Artist = getItem(position) as Artist
        viewHolder.txtName.text = artist.name
        viewHolder.ivImagen.setImageResource(artist.image)
        return view as View
    }

    //Obtiene el artista en la posición
    override fun getItem(position: Int): Any {
        return artist.get(position)
    }
    //Obtiene la posición id
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //Obtiene el número de artistas
    override fun getCount(): Int {
        return artist.count()
    }
}