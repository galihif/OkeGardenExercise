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

    private val _test = MutableStateFlow("")
    val test = _test
    private fun getTest(){
        viewModelScope.launch {
            repo.test.collect{
                _test.value = it
            }
        }
    }

    init {
        getTest()
    }
}