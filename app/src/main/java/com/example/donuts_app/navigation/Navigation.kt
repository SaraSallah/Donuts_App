package com.example.donuts_app.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.donuts_app.ui.theme.PrimaryColor
import com.example.donuts_app.ui.theme.White

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Favorites,
        BottomBarScreen.Notification,
        BottomBarScreen.Cart,
        BottomBarScreen.Profile
    )
    val bottomBarScreens = listOf(
        BottomBarScreen.OnBoardingScreen.route,
        BottomBarScreen.AddToCartScreen.route,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val showBottomBar = currentDestination?.route !in bottomBarScreens
    if (showBottomBar) {
        BottomNavigation(
            backgroundColor = Color.Transparent,
            elevation = 0.dp
        ) {
            screens.forEach() { screens ->
                AddItem(
                    screen = screens,
                    currentDestination = currentDestination,
                    navController = navController
                )

            }

        }

    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        icon = {
            val isSelected = currentDestination?.hierarchy?.any {
                it.route == screen.route
            } == true

            val iconTintColor = if (isSelected) White else PrimaryColor

            Row(
                modifier = Modifier
                    .size(52.dp)
                    .clip(if (isSelected) CircleShape else RoundedCornerShape(0.dp))
                    .background(if (isSelected) PrimaryColor else Color.Transparent),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Icon(
                    painter = painterResource(screen.icon),
                    contentDescription = screen.route,
                    tint = iconTintColor,
                )
                // Add additional content if needed
            }
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}