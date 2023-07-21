package com.example.donuts_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.donuts_app.screens.CartScreen
import com.example.donuts_app.screens.FavoritesScreen
import com.example.donuts_app.screens.NotificationScreen
import com.example.donuts_app.screens.ProfileScreen
import com.example.donuts_app.screens.add_to_cart.AddToCartScreen
import com.example.donuts_app.screens.home.HomeScreen
import com.example.donuts_app.screens.on_boarding.OnBoardingScreen


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination =
    BottomBarScreen.OnBoardingScreen.route) {

        onBoarding()
        homeRoute()

        composable(route=BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route=BottomBarScreen.Favorites.route) {
            FavoritesScreen()
        }
        composable(route = BottomBarScreen.Notification.route) {
            NotificationScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomBarScreen.Cart.route){
            CartScreen()
        }
        addToCart()

    }
}
fun NavGraphBuilder.homeRoute() {
    composable(route = BottomBarScreen.Home.route) {
        HomeScreen()
    }
}
fun NavGraphBuilder.addToCart() {
    composable(route = BottomBarScreen.AddToCartScreen.route) {
        AddToCartScreen()
    }
}
fun NavGraphBuilder.onBoarding() {
    composable(route = BottomBarScreen.OnBoardingScreen.route) {
        OnBoardingScreen()
    }
}