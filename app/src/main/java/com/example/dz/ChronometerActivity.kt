package com.example.dz

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.Chronometer
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_chronometer.*

const val DURATION="duration"


class ChronometerActivity : AppCompatActivity() {

    private lateinit var timePicker: TimePicker

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chronometer)

        timePicker=findViewById(R.id.timePicker)
        timePicker.setIs24HourView(true)
        timePicker.minute=0
        timePicker.hour=0
        val intent = Intent(this,MyForegroundService::class.java)

        buttonStart.setOnClickListener {

            val duration=timePicker.hour*60+timePicker.minute
            intent.putExtra(DURATION,duration)
            startService(intent)

        }
    }
}