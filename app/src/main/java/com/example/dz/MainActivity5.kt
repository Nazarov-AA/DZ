package com.example.dz

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main5.*

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)


        cat.setBackgroundResource(R.drawable.cats)

        val myCat: AnimationDrawable = cat.background as AnimationDrawable

        myCat.start()

    }
}