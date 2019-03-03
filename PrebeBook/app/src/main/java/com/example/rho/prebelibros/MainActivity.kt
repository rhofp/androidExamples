package com.example.rho.prebelibros

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadCapitulos(CapsFragment())
    }
    private fun loadCapitulos(fr1:CapsFragment){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.capitulos,fr1)
        ft.commit()
    }
}
