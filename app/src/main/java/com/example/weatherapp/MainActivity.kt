package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.screens.HomeScreenUI
import com.example.weatherapp.ui.screens.SplashScreenUI
import com.example.weatherapp.ui.theme.WeatherAppTheme

val PrimaryBackground = Color(0xFFE0E0E0) // Define your color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // Initialize NavController for navigation
                val navController = rememberNavController()

                Surface(color = PrimaryBackground, modifier = Modifier.fillMaxSize()) {
                    // Set up the NavHost with different screens
                    NavHost(navController = navController, startDestination = "splash") {
                        composable("splash") {
                            SplashScreenUI(navController)
                        }
                        composable("home") {
                            HomeScreenUI()
                        }
                    }
                }
            }
        }
    }
}
