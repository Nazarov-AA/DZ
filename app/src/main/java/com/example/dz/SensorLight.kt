package com.example.dz

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sensor_light.*

class SensorLight : AppCompatActivity(), SensorEventListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_light)

        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        sensorManager.registerListener(this,lightSensor,1)

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {

        if(event?.values?.get(0) != null && event.values?.get(0)!! >= 300){
            constrL.setBackgroundColor(Color.parseColor("#84F403"))

        }else constrL.setBackgroundColor(Color.parseColor("#F40303"))


        tv_light.text = event?.values?.get(0).toString()

    }
}