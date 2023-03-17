package com.example.okegardenexercise.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ResultScreen() {
    var celcius by remember { mutableStateOf("") }
    var fahrenheit by remember { mutableStateOf("") }
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(value = celcius, onValueChange = { celcius = it }, label = { Text(text = "Celcius") })
            OutlinedTextField(value = fahrenheit, onValueChange = { fahrenheit = it}, label = { Text(text = "Fahrenheit") })
        }
    }
}