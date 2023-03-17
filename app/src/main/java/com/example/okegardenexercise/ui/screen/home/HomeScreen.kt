package com.example.okegardenexercise.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.okegardenexercise.ui.components.CityNameDropdown
import com.example.okegardenexercise.ui.screen.home.HomeViewModel

@ExperimentalMaterialApi
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    onSubmitClicked: () -> Unit,
    viewModel:HomeViewModel = hiltViewModel()
) {
    val test by viewModel.test.collectAsState()
    val apiKey by remember {
        mutableStateOf("ff9f895b2e884d6680530135202710")
    }
    var selectedCity by remember {
        mutableStateOf("Kuala Lumpur")
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
                onValueChange = {},
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
                    .padding(top = 16.dp), onClick = onSubmitClicked
            ) {
                Text(
                    text = test,
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                )
            }
        }
    }
}