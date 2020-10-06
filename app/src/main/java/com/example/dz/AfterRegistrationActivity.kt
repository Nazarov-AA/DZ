package com.example.dz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_after_registration.*


private const val Person_KEY = "person key"

class AfterRegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_registration)

        val myPerson = intent.getParcelableExtra<Person>(Person_KEY)

        val name = myPerson?.name
        textViewWelcome.text = "Добро пожаловать $name "
    }
}