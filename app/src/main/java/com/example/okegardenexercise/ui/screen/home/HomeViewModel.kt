package com.example.okegardenexercise.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.okegardenexercise.data.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val repo: MainRepository
) : ViewModel() {

    private val _tempCelcius = MutableStateFlow(0.0)
    val tempCelcius = _tempCelcius

    private val _tempFahrenheit = MutableStateFlow(0.0)
    val tempFahrenheit = _tempFahrenheit

    private val _loading = MutableStateFlow(false)
    val loading = _loading

    fun getWeatherData(key: String, cityName: String) {
        _loading.value = true
        viewModelScope.launch {
            repo.getWeather(key, cityName).collect {
                _tempCelcius.value = it.current.tempC.toDouble()
                _tempFahrenheit.value = it.current.tempF
                _loading.value = false
            }
        }
    }

    init {

    }
}