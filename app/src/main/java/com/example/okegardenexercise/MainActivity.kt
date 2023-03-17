package com.example.okegardenexercise

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.okegardenexercise.data.model.Weather
import com.example.okegardenexercise.ui.screen.home.HomeScreen
import com.example.okegardenexercise.ui.screen.ResultScreen
import com.example.okegardenexercise.ui.theme.OkeGardenExerciseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OkeGardenExerciseTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Home"
    ){
        composable("Home"){
            HomeScreen(
                onResult = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("weather",it)
                    navController.navigate("Result/weather")
                    Log.d("GALIH", "MyApp: ${it.tempCelcius}")
                }
            )
        }
        composable("Result/weather"){
            val weather = navController.previousBackStackEntry?.savedStateHandle?.get<Weather>("weather")
            ResultScreen(weather = weather?: Weather(0.0,0.0))
        }

    }
}
