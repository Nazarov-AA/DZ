package com.example.dz

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Build
import android.os.CountDownTimer
import android.os.IBinder
import android.util.Log
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

const val NOTIFICATION_ID = 1

class MyForegroundService:Service() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()


            startForeground(NOTIFICATION_ID, getNotification(""))
        
    }

//        val broadcastIntent = Intent(this,MyReciver::class.java)
//        broadcastIntent.putExtra(KEY,"Hello broadcast")
//
//        val pendingIntent = PendingIntent.getBroadcast(
//            this,1,broadcastIntent, PendingIntent.FLAG_CANCEL_CURRENT)



//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val notification = Notification.Builder(this, NOTIFICATION_CHANNEL_ID)
//                .setContentTitle("Chronometer")
//                .setContentText("chronometer")
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .addAction(
//                    Notification.Action.Builder(
//                        Icon.createWithResource(this,R.drawable.ic_launcher_foreground),
//                        "go to app",
//                        pendingIntent
//
//                    ).build()
//                ).build()
//
//            startForeground(1,notification)
//        }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


        val duration = intent?.getIntExtra(DURATION, 0) ?: 0
        val timer = object : CountDownTimer(duration * 1000L, 1000) {

            val manager = getSystemService(NotificationManager::class.java)


            @RequiresApi(Build.VERSION_CODES.O)
            override fun onFinish() {
                manager.notify(1, getNotification("Timer is over"))
                stopSelf()
            }

            @RequiresApi(Build.VERSION_CODES.O)
            override fun onTick(millisUntilFinished: Long) {
                val minutes = millisUntilFinished / 60000
                val seconds = millisUntilFinished / 1000 % 60
                manager.notify(
                    NOTIFICATION_ID, getNotification(
                        String.format("%02d:%02d", minutes, seconds)
                    )
                )
            }
        }
        timer.start()
        return super.onStartCommand(intent, flags, startId)
    }




    @RequiresApi(Build.VERSION_CODES.O)
    private fun getNotification(text: String): Notification {
        val intent = Intent(this, ChronometerActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            0
        )
        val notification = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setContentTitle("NOTIFICATION TITLE")
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setCustomContentView(
                RemoteViews(packageName, R.layout.notification_layout).apply {
                    setTextViewText(R.id.textView_notification_timer, text)
                }
            )
            .setContentIntent(pendingIntent)
            .setSmallIcon(R.mipmap.ic_launcher)
        return notification.build()
    }

}
