package com.example.dz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dz.adapter.CryptoAdapter
import com.example.dz.dto.Json
import com.example.dz.mapers.RatesMappers
import com.example.dz.retrofit.RetrofitFactory
import kotlinx.android.synthetic.main.activity_api.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ApiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)


        val retrofit = RetrofitFactory().getRetrofit()
        //val cryptoAdapter = CryptoAdapter()
        button_get.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {

                val response = retrofit.getRates().await()

                if (response.isSuccessful){

                    val ratesResponse = response.body()?.data
                    val rates = ratesResponse?.map {

                            RatesMappers().map(it)

                    }

                    withContext(Dispatchers.Main){                        //main поток что бы работать с UI
                        text_rates.text = rates.toString()
                        //cryptoAdapter.updateList(rates)
                    }
                }else{
                    Toast.makeText(this@ApiActivity,"ERROR", Toast.LENGTH_SHORT).show()
                }

                val myIntent = Intent(this@ApiActivity, AllCryptocurrenciesActivity::class.java)
                startActivity(myIntent)

            }
        }

    }
}