package com.example.dz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.example.k_02.MyVM2
import kotlinx.android.synthetic.main.activity_main6.*

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val myVM2: MyVM2 = ViewModelProvider(this).get(MyVM2::class.java)

        myVM2.potatoes1.observe(this, Observer {
            textView4.text = it.toString()
        })

        myVM2.cabbage1.observe(this, Observer {
            textView5.text = it.toString()
        })

        myVM2.beet1.observe(this, Observer {
            textView6.text = it.toString()
        })


        myVM2.potatoes2.observe(this, Observer {
            textView2_4.text = it.toString()
        })

        myVM2.cabbage2.observe(this, Observer {
            textView2_5.text = it.toString()
        })

        myVM2.beet2.observe(this, Observer {
            textView2_6.text = it.toString()
        })


        myVM2.potatoes3.observe(this, Observer {
            textView3_4.text = it.toString()
        })

        myVM2.cabbage3.observe(this, Observer {
            textView3_5.text = it.toString()
        })

        myVM2.beet3.observe(this, Observer {
            textView3_6.text = it.toString()
        })

        myVM2.winner.observe(this, Observer {
            textView007.text = it.toString()
        })

        buttonGo.setOnClickListener {
                myVM2.update()
        }


    }
}