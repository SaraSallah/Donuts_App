package com.example.donuts_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.donuts_app.navigation.BottomBarScreen
import com.example.donuts_app.ui.theme.PinkBackground

@Composable
fun FavoritesScreen(){
    Text(text = "Favorite Screen",
    modifier = Modifier.fillMaxSize().background(PinkBackground))
}