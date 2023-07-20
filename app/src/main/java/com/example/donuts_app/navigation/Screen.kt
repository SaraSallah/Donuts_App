package com.example.donuts_app.navigation


sealed class Screen(val route: String){
    object onBoardingScreen: Screen("OnBoardingScreen")
    object HomeScreen: Screen("HomeScreen")
    object AddToCartScreen: Screen("AddToCartScreen")
    object CartScreen: Screen("CartScreen")
}
