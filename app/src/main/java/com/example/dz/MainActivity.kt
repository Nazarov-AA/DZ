package com.example.dz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.k_02.MyVM2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main6.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            val myIntent = Intent(this, MainActivity2::class.java)
            startActivity(myIntent)
        }

        button2.setOnClickListener {
            val myIntent2 = Intent(this, MainActivity3::class.java)
            startActivity(myIntent2)
        }

        button3.setOnClickListener {
            val myIntent3 = Intent(this, MainActivity6::class.java)
            startActivity(myIntent3)
        }

        button6.setOnClickListener {

            val myIntent = Intent(this, MainActivityCoffee::class.java)
            startActivity(myIntent)
        }

        button7.setOnClickListener {

            val myIntent = Intent(this, RegistrationActivity::class.java)
            startActivity(myIntent)
        }


        button9.setOnClickListener {

            val myIntent = Intent(this, AddProductActivity::class.java)
            startActivity(myIntent)
        }

            buttonDZ6.setOnClickListener {

                val myIntent = Intent(this, Dz_6Activity::class.java)

                startActivity(myIntent)
            }

            button10.setOnClickListener {

                val myIntent = Intent(this, ApiActivity::class.java)
                startActivity(myIntent)
            }

            button11.setOnClickListener {

                val myIntent = Intent(this, ChronometerActivity::class.java)
                startActivity(myIntent)
            }


        }
    }
