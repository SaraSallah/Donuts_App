package com.example.donuts_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.donuts_app.screens.CartScreen
import com.example.donuts_app.screens.add_to_cart.AddToCartScreen
import com.example.donuts_app.screens.home.HomeScreen
import com.example.donuts_app.screens.on_boarding.OnBoardingScreen
import com.example.donuts_app.ui.theme.Donuts_AppTheme


@Composable
fun Donuts(){
    Donuts_AppTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "onBoardingScreen") {
            composable(Screen.onBoardingScreen.route) { OnBoardingScreen(navController) }
            composable(Screen.HomeScreen.route) { HomeScreen(navController) }
            composable(Screen.AddToCartScreen.route) { AddToCartScreen(navController) }
            composable(Screen.CartScreen.route) { CartScreen() }
        }
    }
}