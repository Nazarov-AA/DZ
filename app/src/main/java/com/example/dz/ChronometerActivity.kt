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


//        val intent = Intent(this,MyForegroundService::class.java)
//        val broadcastIntent = Intent(this,MyReciver::class.java)
//        broadcastIntent.putExtra(KEY,"Hello broadcast")


//        var chronometer = findViewById<Chronometer>(R.id.chronometer)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            chronometer.setCountDown(true)
//        }
//        chronometer.setOnChronometerTickListener {
//            var elapsedMillis = (SystemClock.elapsedRealtime() - chronometer.base)
//            //var elapsedMillis = 10000
//            if (elapsedMillis < 1000){
//                startService(intent)
//            }
//        }

        buttonStart.setOnClickListener {

            val duration=timePicker.hour*60+timePicker.minute
            intent.putExtra(DURATION,duration)
            startService(intent)

//            chronometer.base = SystemClock.elapsedRealtime()
//            chronometer.start()

//            val timer = object : CountDownTimer(5000,1000){
//                override fun onFinish() {
//
//                    startService(intent)
//                }
//
//                override fun onTick(millisUntilFinished: Long) {
//
//                    if (millisUntilFinished < 1000){
//                        startService(intent)
//                    }
//
//                }
//
//            }.start()
////timer.start()
        }



//        val myServiceConnection = object : ServiceConnection {             // для BoundService
//            override fun onServiceDisconnected(name: ComponentName?) {
//
//            }
//
//            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
//
//                val binder =  service as MyBoundService.MyBinder
//
//                boundServiceInstance = binder.getService()
//
//                boundServiceInstance.show()
//
//            }
//
//        }


    }
}