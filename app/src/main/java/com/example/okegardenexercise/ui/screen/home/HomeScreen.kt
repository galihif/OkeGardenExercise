package com.example.okegardenexercise.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.okegardenexercise.data.model.Weather
import com.example.okegardenexercise.ui.components.CityNameDropdown
import com.example.okegardenexercise.ui.screen.home.HomeViewModel

@ExperimentalMaterialApi
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    onResult: (Weather) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val tempC by viewModel.tempCelcius.collectAsState()
    val tempF by viewModel.tempFahrenheit.collectAsState()

    var apiKey by remember {
        mutableStateOf("ff9f895b2e884d6680530135202710")
    }
    var selectedCity by remember {
        mutableStateOf("Kuala Lumpur")
    }

    val loading by viewModel.loading.collectAsState()

    LaunchedEffect(tempC) {
        if (tempC != 0.0 && tempF != 0.0) {
            onResult(Weather(tempC, tempF))
            viewModel.setDefault()
        }
    }

    Scaffold {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = apiKey,
                onValueChange = { apiKey = it },
                label = { Text("Your API Key") }
            )
            CityNameDropdown(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                selectedOption = selectedCity,
                onOptionSelected = { selectedCity = it }
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                onClick = {
                    viewModel.getWeatherData(apiKey, selectedCity)
                }
            ) {
                Text(
                    text = if (loading) "Loading..." else "Submit",
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                )
            }
        }
    }
}