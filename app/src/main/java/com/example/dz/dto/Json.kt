package com.example.dz.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Json(
    @Json(name = "data")
    var data: List<DataResponse>? = null,
    @Json(name = "status")
    var status: Status? = null
) {
    @JsonClass(generateAdapter = true)
    data class DataResponse(
//        @Json(name = "circulating_supply")
//        var circulatingSupply: Double? = null,
//        @Json(name = "cmc_rank")
//        var cmcRank: Int? = null,
//        @Json(name = "date_added")
//        var dateAdded: String? = null,
        @Json(name = "id")
        var id: Long? = null,
//        @Json(name = "last_updated")
//        var lastUpdated: String? = null,
//        @Json(name = "max_supply")
//        var maxSupply: Int? = null,
        @Json(name = "name")
        var name: String? = null,
//        @Json(name = "num_market_pairs")
//        var numMarketPairs: Int? = null,
//        @Json(name = "platform")
//        var platform: Any? = null,
        @Json(name = "quote")
        var quote: Quote? = null
//        @Json(name = "slug")
//        var slug: String? = null,
//        @Json(name = "symbol")
//        var symbol: String? = null,
//        @Json(name = "tags")
//        var tags: List<String?>? = null,
//        @Json(name = "total_supply")
//        var totalSupply: Int? = null
    ) {
        @JsonClass(generateAdapter = true)
        data class Quote(
            @Json(name = "USD")
            var uSD: USD? = null
        ) {
            @JsonClass(generateAdapter = true)
            data class USD(
//                @Json(name = "last_updated")
//                var lastUpdated: String? = null,
//                @Json(name = "market_cap")
//                var marketCap: Double? = null,
//                @Json(name = "percent_change_1h")
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

    @JsonClass(generateAdapter = true)
    data class Status(
        @Json(name = "credit_count")
        var creditCount: Long? = null,
        @Json(name = "elapsed")
        var elapsed: Long? = null,
        @Json(name = "error_code")
        var errorCode: Long? = null,
        @Json(name = "error_message")
        var errorMessage: Any? = null,
        @Json(name = "notice")
        var notice: Any? = null,
        @Json(name = "timestamp")
        var timestamp: String? = null,
        @Json(name = "total_count")
        var totalCount: Long? = null
    )
}