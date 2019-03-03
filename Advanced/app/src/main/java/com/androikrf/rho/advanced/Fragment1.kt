package com.androikrf.rho.advanced

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_fragment1.*

class Fragment1 : Fragment(), SensorEventListener {

    var whip = 0

    val sensorManager: SensorManager by lazy {
        activity!!.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false)
    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        //Encuentra al sensor
        if (event!!.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            getAccelerometer(event)
        }
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(
            this,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }


    private fun getAccelerometer(event: SensorEvent) {
        // Movement
        val xVal = event.values[0]
        //val yVal = event.values[1]
        //val zVal = event.values[2]
        tvXAxiz.text = "X Value: ".plus(xVal.toString())

        if (xVal<-5 && whip == 0){
            whip++
            relative.setBackgroundColor(Color.CYAN)
        }else if (xVal>5 && whip==1){
            relative.setBackgroundColor(Color.YELLOW)
            whip++
        }else if (xVal<5 && xVal>-5){
            relative.setBackgroundColor(Color.GREEN)
            whip++
        }

        if (whip == 3){
            whip = 0
        }

    }


}
