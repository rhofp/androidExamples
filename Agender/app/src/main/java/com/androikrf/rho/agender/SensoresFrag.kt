package com.androikrf.rho.agender


import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_sensores.*

class SensoresFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sensores, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        acelBtn.setOnClickListener {
            //Toast.makeText(activity?.applicationContext,"Ya sirve el boton",Toast.LENGTH_SHORT).show()
            activity.reemplazarFragment(
                fragment = BlankFragment(),
                allowStateLoss = true,
                contenedor = R.id.contenedor_maestro
            )
        }
        proxBtn.setOnClickListener {
            //Toast.makeText(activity?.applicationContext,"Ya sirve el boton",Toast.LENGTH_SHORT).show()
            activity.reemplazarFragment(
                fragment = ProxFrag(),
                allowStateLoss = true,
                contenedor = R.id.contenedor_maestro
            )
        }
    }

}

fun FragmentActivity?.reemplazarFragment(
    fragment: Fragment,
    allowStateLoss :Boolean = false,
    @IdRes contenedor: Int
){
    val ft = this!!.supportFragmentManager.beginTransaction().replace(contenedor,fragment)

    if(!supportFragmentManager.isStateSaved){
        ft.addToBackStack(null)
        ft.commit()
    }else{
        ft.commitAllowingStateLoss()
    }

}
