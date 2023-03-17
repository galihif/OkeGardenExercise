package com.example.okegardenexercise.data.remote.dto


import com.google.gson.annotations.SerializedName

data class WeatherDataDto(
    @SerializedName("current")
    val current: Current,
    @SerializedName("location")
    val location: Location
) {
    data class Current(
        @SerializedName("temp_c")
        val tempC: Int,
        @SerializedName("temp_f")
        val tempF: Double,
    )

    data class Location(
        @SerializedName("country")
        val country: String,
        @SerializedName("lat")
        val lat: Double,
        @SerializedName("localtime")
        val localtime: String,
        @SerializedName("localtime_epoch")
        val localtimeEpoch: Int,
        @SerializedName("lon")
        val lon: Double,
        @SerializedName("name")
        val name: String,
        @SerializedName("region")
        val region: String,
        @SerializedName("tz_id")
        val tzId: String
    )
}