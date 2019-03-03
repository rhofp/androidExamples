package com.example.sistemas.listviewofficial2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ArtistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist)

        var listView = findViewById(R.id.listView) as ListView
        var arrArtistas: ArrayList<Artist> = ArrayList()
        arrArtistas.add(Artist("Michael", R.drawable.michael))
        listView.adapter = CustomAdapter(applicationContext, arrArtistas)
    }
}