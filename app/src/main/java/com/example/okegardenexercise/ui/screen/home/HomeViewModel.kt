package com.example.okegardenexercise.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.okegardenexercise.data.MainRepository
import com.example.okegardenexercise.data.model.Weather
import com.example.okegardenexercise.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val repo: MainRepository
) : ViewModel() {


    private val _weather = MutableStateFlow<Resource<Weather>>(Resource.Loading())
    val weather = _weather

    private val _loading = MutableStateFlow(false)
    val loading = _loading



    fun getWeatherData(key: String, cityName: String) {
        _loading.value = true
        viewModelScope.launch {
            repo.getWeather(key, cityName).collect {
                when (it) {
                    is Resource.Success -> {
                        _weather.value = it
                        _loading.value = false
                    }
                    is Resource.Error -> {
                        _weather.value = it
                        _loading.value = false
                    }
                    is Resource.Loading -> {
                        _weather.value = it
                        _loading.value = true
                    }
                }
            }
        }
    }

    fun setDefaultWeather() {
        _weather.value = Resource.Loading()
        _loading.value = false
    }

    init {

    }
}