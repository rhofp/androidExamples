package com.androikrf.rho.advanced

import android.support.v4.app.Fragment
import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity

/**
 * Created by nir21 on 23-01-2018.
 */

// extension!
fun AppCompatActivity.replaceFragmenty(fragment: Fragment,
                                       allowStateLoss: Boolean = false,
                                       @IdRes containerViewId: Int) {
    val ft = supportFragmentManager
        .beginTransaction()
        .replace(containerViewId, fragment)
    if (!supportFragmentManager.isStateSaved) {
        ft!!.addToBackStack(null)
        ft.commit()
    } else if (allowStateLoss) {
        ft.commitAllowingStateLoss()
    }
}