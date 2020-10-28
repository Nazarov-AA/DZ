package com.example.dz.networking

import com.example.dz.dto.Json
import com.example.dz.dto.RatesResponse
import kotlinx.coroutines.Deferred
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinMarketCapApi {

    @GET("v1/cryptocurrency/listings/latest")
    fun getRates() : Deferred<retrofit2.Response<Json>>
}