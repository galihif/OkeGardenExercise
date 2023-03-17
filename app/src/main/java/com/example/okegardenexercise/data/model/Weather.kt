package com.example.okegardenexercise.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather(
    val tempCelcius:Double,
    val tempFahrenheit:Double,
):Parcelable
