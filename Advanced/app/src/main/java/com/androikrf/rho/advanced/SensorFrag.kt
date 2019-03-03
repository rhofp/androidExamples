package com.androikrf.rho.advanced


import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_sensor.*

class SensorFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_sensor, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        acelBtn.setOnClickListener {
/*            activity.replaceFragmentyFF(
                fragment = Fragment1(),
                allowStateLoss = true,
                containerViewId = R.id.content_main
            )*/
        }

        proxBtn.setOnClickListener {
/*            activity.replaceFragmentyFF(
                fragment = ProxFrag(),
                allowStateLoss = true,
                containerViewId = R.id.content_main
            )*/
        }
    }
}

fun FragmentActivity?.
        replaceFragmentyFF(
            fragment: Fragment,
            allowStateLoss: Boolean = false,
            @IdRes containerViewId: Int) {
    val ft = this!!.
        supportFragmentManager?.
        beginTransaction()?.
        replace(containerViewId, fragment)

    if (!supportFragmentManager.isStateSaved) {
        ft!!.addToBackStack(null)
        ft.commit()
    } else if (allowStateLoss) {
        ft!!.commitAllowingStateLoss()
    }
}