package com.example.okegardenexercise.data

import com.example.okegardenexercise.data.model.Weather
import com.example.okegardenexercise.data.remote.api.ApiService
import com.example.okegardenexercise.data.remote.dto.toWeather
import com.example.okegardenexercise.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val api: ApiService
) {
    suspend fun getWeather(
        key: String,
        q: String,
    ): Flow<Resource<Weather>> =
        flow{
        emit(Resource.Loading())
            try {
                val res = api.getWeather(key, q)
                emit(Resource.Success(res.toWeather()))
            }catch (e: HttpException) {
                emit(Resource.Error(e.message() ?: "Unexpected error occured"))
            } catch (e: IOException) {
                emit(Resource.Error(e.message ?: "Unexpected error occured"))
            }
    }
}