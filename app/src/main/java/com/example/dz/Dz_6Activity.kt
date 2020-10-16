package com.example.dz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.activity_dz_6.*

class Dz_6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz_6)

        YoYo.with(Techniques.Bounce)
            .repeat(3)
            .duration(500)
            .playOn(buttonCongratulation)

        buttonCongratulation.setOnClickListener {
           overrideAndStart()
        }

    }

    private fun overrideAndStart() {
        startActivity(Intent(this, CongratulationActivity::class.java))
        overridePendingTransition(R.anim.enter,R.anim.exit)
    }
}