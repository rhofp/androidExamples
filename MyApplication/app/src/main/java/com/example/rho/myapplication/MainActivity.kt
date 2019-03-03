package com.example.rho.myapplication

import android.content.Context
import android.graphics.Color
import android.graphics.Color.BLUE
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),SensorEventListener {

    var whip = 0

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(event!!.sensor.type == Sensor.TYPE_ACCELEROMETER){
            var x = event?.values!![0]
            valor_x.text = "X: $x"

            if (x<-5 && whip==0){
                whip++
                contenedor.setBackgroundColor(Color.BLUE)
            }else if (x>5 && whip==1){
                whip++
                contenedor.setBackgroundColor(Color.RED)
            }
            if (whip==2){
                whip=0
            }
        }


    }

    lateinit var sensorManager: SensorManager
    lateinit var sensor: Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        if (sensor==null)
            Toast.makeText(this,"No tienes acelerometro we",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this,"Si tienes sensor",Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
    }

}
