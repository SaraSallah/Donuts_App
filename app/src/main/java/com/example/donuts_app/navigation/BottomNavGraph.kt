package com.example.donuts_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.donuts_app.screens.CartScreen
import com.example.donuts_app.screens.FavoritesScreen
import com.example.donuts_app.screens.NotificationScreen
import com.example.donuts_app.screens.ProfileScreen
import com.example.donuts_app.screens.home.HomeScreen


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
        composable(BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(BottomBarScreen.Favorites.route) {
            FavoritesScreen()
        }
        composable(BottomBarScreen.Notification.route) {
            NotificationScreen()
        }
        composable(BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
        composable(BottomBarScreen.Cart.route){
            CartScreen()
        }
    }
}