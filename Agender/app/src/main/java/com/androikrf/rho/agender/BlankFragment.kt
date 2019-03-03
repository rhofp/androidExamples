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
import kotlinx.android.synthetic.main.fragment_blank.*


class BlankFragment : Fragment(), SensorEventListener {


    val sensorManager:SensorManager by lazy {
        activity?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }


    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(event!!.sensor.type == Sensor.TYPE_ACCELEROMETER){
            acelerometro(event)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onResume() {
        super.onResume()

        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()

        sensorManager.unregisterListener(this)
    }

    fun acelerometro(event: SensorEvent){


        var xvalue = event.values[0]
        var yvalue = event.values[1]
        var zvalue = event.values[2]

        xval.text = xvalue.toString()
        yval.text = yvalue.toString()
        zval.text = zvalue.toString()


        if (xvalue<=-5)
            relative.setBackgroundColor(Color.GREEN)
        else if (xvalue>=5)
            relative.setBackgroundColor(Color.RED)
        else
            relative.setBackgroundColor(Color.GRAY)



    }


}
