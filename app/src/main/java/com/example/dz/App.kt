package com.example.dz

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi

const val NOTIFICATION_CHANNEL_ID = "Channel id"
const val NOTIFICATION_CHANNEL_NAME = "Channel name"

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNatificationChannel()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNatificationChannel(){

        val channel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            NOTIFICATION_CHANNEL_NAME,
            NotificationManager.IMPORTANCE_HIGH
        )

        val manager = getSystemService(NotificationManager::class.java)

        manager.createNotificationChannel(channel)

    }

}