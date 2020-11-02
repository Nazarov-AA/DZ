package com.example.dz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dz.adapter.CryptoAdapter
import com.example.dz.entity.Rates
import com.example.dz.mapers.RatesMappers
import com.example.dz.retrofit.RetrofitFactory
//import com.example.dz.entity.cryptoSet
import kotlinx.android.synthetic.main.activity_all_cryptocurrencies.*
import kotlinx.android.synthetic.main.activity_api.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AllCryptocurrenciesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_cryptocurrencies)


        //  val adapter = CryptoAdapter(cryptoSet.getCrypto())
        val adapter = CryptoAdapter()

        cryptoRecycler.adapter = adapter
        cryptoRecycler.layoutManager = LinearLayoutManager(this)
        cryptoRecycler.hasFixedSize()


        val retrofit = RetrofitFactory().getRetrofit()
        //val cryptoAdapter = CryptoAdapter()

        CoroutineScope(Dispatchers.IO).launch {

            val response = retrofit.getRates().await()

            if (response.isSuccessful) {

                val ratesResponse = response.body()?.data
                val rates = ratesResponse?.map {

                    RatesMappers().map(it)

                }

                withContext(Dispatchers.Main) {                        //main поток что бы работать с UI
                    //text_rates.text = rates.toString()
                    adapter.updateList(rates)
                    //cryptoAdapter.updateList(listOf(Rates(1,"BTC0",2.5,2.0)))
                }


            }else{
                Toast.makeText(this@AllCryptocurrenciesActivity,"ERROR", Toast.LENGTH_SHORT).show()
            }

        }
    }
}