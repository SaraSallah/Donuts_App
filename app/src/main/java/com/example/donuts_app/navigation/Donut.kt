package com.example.donuts_app.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.donuts_app.screens.CartScreen
import com.example.donuts_app.screens.add_to_cart.AddToCartScreen
import com.example.donuts_app.screens.home.HomeScreen
import com.example.donuts_app.screens.on_boarding.OnBoardingScreen
import com.example.donuts_app.ui.theme.Donuts_AppTheme


val LocalNavigationProvider = staticCompositionLocalOf<NavHostController> {
    error("No navigation host controller provided.")
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Donuts_App() {
    val navController = rememberNavController()
    Scaffold(
        Modifier.fillMaxHeight(),
        bottomBar = {
            BottomBar(navController)
        }
    )
    { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            CompositionLocalProvider(LocalNavigationProvider provides navController) {
                BottomNavGraph(navController)
            }
        }
    }
}
//@Composable
//fun Donuts(){
//    Donuts_AppTheme {
//        val navController = rememberNavController()
//        NavHost(navController = navController, startDestination = "onBoardingScreen") {
//            composable(Screen.onBoardingScreen.route) { OnBoardingScreen(navController) }
//            composable(Screen.HomeScreen.route) { HomeScreen(navController) }
//            composable(Screen.AddToCartScreen.route) { AddToCartScreen(navController) }
//            composable(Screen.CartScreen.route) { CartScreen() }
//        }
//    }
//}