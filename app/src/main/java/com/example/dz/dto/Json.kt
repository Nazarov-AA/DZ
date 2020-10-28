package com.example.dz.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Json(
    @Json(name = "data")
    var data: List<DataResponse>? = null
//    @Json(name = "status")
//    var status: Status? = null
) {
    @JsonClass(generateAdapter = true)
    data class DataResponse(
        @Json(name = "id")
        var id: Long? = null,
        @Json(name = "name")
        var name: String? = null,
        @Json(name = "quote")
        var quote: Quote? = null
    ) {
        @JsonClass(generateAdapter = true)
        data class Quote(
            @Json(name = "USD")
            var uSD: USD? = null
        ) {
            @JsonClass(generateAdapter = true)
            data class USD(
                var percentChange1h: Double? = null,
                @Json(name = "percent_change_24h")
                var percentChange24h: Double? = null,
                @Json(name = "percent_change_7d")
                var percentChange7d: Double? = null,
                @Json(name = "price")
                var price: Double? = null,
                @Json(name = "volume_24h")
                var volume24h: Double? = null
            )
        }
    }
}