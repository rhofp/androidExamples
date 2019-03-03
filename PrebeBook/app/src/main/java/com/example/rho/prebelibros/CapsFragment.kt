package com.example.rho.prebelibros


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

class CapsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val lf = LayoutInflater.from(container?.context).inflate(R.layout.fragment_caps,container,false)
        //getting recyclerview from xml
        val recyclerView = lf.findViewById(R.id.recyclerView) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(container?.context, LinearLayout.VERTICAL, false)


        //crating an arraylist to store users using the data class user
        val caps = ArrayList<Capitulos>()

        //adding some dummy data to the list
        caps.add(Capitulos("Capitulo 1", "Henry"))
        caps.add(Capitulos("Capitulo 2", "Henry I"))
        caps.add(Capitulos("Capitulo 3", "Richard"))
        caps.add(Capitulos("Capitulo 4", "Richard II"))

        //creating our adapter
        val adapter = CustomAdapter(caps)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter

        return lf
    }


}
