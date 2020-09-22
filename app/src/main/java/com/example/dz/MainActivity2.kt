package com.example.dz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        buttonLoad.setOnClickListener{

            val url = editText.text.toString()

            if (url.isNotEmpty()) {
                Picasso.get().load(url).into(imageView)
            }
        }
    }
}