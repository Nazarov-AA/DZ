package com.example.dz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            val myIntent = Intent(this,MainActivityCoffee::class.java)
            startActivity(myIntent)
        }

        button2.setOnClickListener {
            val myIntent2 = Intent(this,MainActivity3::class.java)
            startActivity(myIntent2)
        }

    }

    override fun onStart() {
        super.onStart()
    }
}