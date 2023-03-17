package com.example.okegardenexercise.data

import com.example.okegardenexercise.data.remote.api.ApiService
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val api: ApiService
) {
    val test = flowOf("test")
}