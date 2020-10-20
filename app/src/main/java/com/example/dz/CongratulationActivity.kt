package com.example.dz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.activity_congratulation.*
import kotlinx.android.synthetic.main.activity_dz_6.*

class CongratulationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congratulation)

        val anim = AnimationUtils.loadAnimation(this, R.anim.enter2)
        backgroungCongratulation.startAnimation(anim)

        val anim2 = AnimationUtils.loadAnimation(this, R.anim.enter3)
        textView7.startAnimation(anim2)

        val anim3 = AnimationUtils.loadAnimation(this, R.anim.enter4)
        textView8.startAnimation(anim3)

        YoYo.with(Techniques.Flash)
            .repeat(3)
            .duration(3000)
            .playOn(textView7)

        YoYo.with(Techniques.Pulse)
            .repeat(3)
            .duration(3000)
            .playOn(textView8)


    }
    override fun onBackPressed(){
        super.onBackPressed()
        overridePendingTransition(R.anim.enter, R.anim.exit)
    }
}