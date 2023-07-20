package com.example.donuts_app.navigation

import com.example.donuts_app.R

sealed class BottomBarScreen(
    val route: String,
    val icon: Int,
) {
    object Home : BottomBarScreen(
        route = "home",
        icon = R.drawable.home
    )

    object Favorites : BottomBarScreen(
        route = "favorites",
        icon = R.drawable.heart
    )

    object Notification : BottomBarScreen(
        route = "notification",
        icon = R.drawable.notification
    )

    object Profile : BottomBarScreen(
        route = "profile",
        icon = R.drawable.user
    )
    object Cart :BottomBarScreen(
        route = "cart",
        icon =R.drawable.buy
    )
}