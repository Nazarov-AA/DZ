package com.example.dz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        button4.setOnClickListener {
            val myIntent2 = Intent(this,MainActivity4::class.java)
            startActivity(myIntent2)
        }

        button5.setOnClickListener {
            val myIntent2 = Intent(this,MainActivity5::class.java)
            startActivity(myIntent2)
        }

    }
}