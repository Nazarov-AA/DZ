package com.example.dz.mapers

import com.example.dz.dto.Json
import com.example.dz.dto.Json.DataResponse.Quote
import com.example.dz.entity.Rates

class RatesMappers {

    fun map(from: Json.DataResponse): Rates {

        return Rates(
            id = from.id ?: 0,
            name = from.name.orEmpty(),
            price = from.quote?.uSD?.price ?: 0.0,
            percentChange24h = from.quote?.uSD?.percentChange24h ?: 0.0
        )
    }


}