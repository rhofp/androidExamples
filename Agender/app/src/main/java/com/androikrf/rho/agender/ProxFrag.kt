package com.androikrf.rho.agender


import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_prox.*


class ProxFrag : Fragment(), SensorEventListener {
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event!!.values[0]< sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY).maximumRange){
            proxContenedor.setBackgroundColor(Color.RED)
        }else{
            proxContenedor.setBackgroundColor(Color.WHITE)
        }
    }

    val sensorManager: SensorManager by lazy {
        activity!!.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prox, container, false)
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),2*1000*1000)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }


}
