package com.example.dz.entity

data class Rates (

    var id: Long,
    var name: String,
    var price: Double,
    var percentChange24h: Double


)

//object cryptoSet{
//
//    fun getCrypto() = listOf<Rates>()
//}