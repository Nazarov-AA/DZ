package com.example.dz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_registration.*


private const val Person_KEY = "person key"

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        materialEditText.addTextChangedListener{
            if (it.isNullOrEmpty()){
                materialTextField.isErrorEnabled = true
                materialTextField.error = "Name must not be empty"

            }else{
                materialTextField.error = null
            }

        }



    }



    fun registr(view: View) {
        if (!materialEditText.text.isNullOrEmpty()) {
            if (!materialPassET.text.isNullOrEmpty() && materialPassET.text!!.length >= 8) {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Success")
                    .setMessage("Are you register")
                    .setNegativeButton("OK") { dialog, which ->
                        dialog.cancel()
                    }
                    .setPositiveButton("Войти") { dialog, which ->
                        val intent = Intent(this, AfterRegistrationActivity::class.java)

                        val myPerson = Person(materialEditText.text.toString())
                        intent.putExtra(Person_KEY, myPerson)

                        startActivity(intent)


                    }
                    .show()
            } else materialPass.helperText = "Пароль должен содержать не менее 8 символов"
        }else materialTextField.helperText = "Имя не должно быть пустым"
    }
}