package com.example.donuts_app.screens.home

data class HomeUiState(
    val todayOffers :List<DonutUiState> = emptyList(),
    val donuts :List<DonutsUiState> = emptyList()
)
data class DonutAppState(
    val todayOffers: List<DonutUiState> = emptyList()
)
data class DonutUiState(
    val images: Int,
    val donutName: String,
    val donutDescription:String,
    val oldPrice:String,
    val newPrice:String,
    val colorBackGround: androidx.compose.ui.graphics.Color,
    val isFav : Boolean = false ,
)
data class DonutsUiState(
    val images : Int ,
    val donutName : String ,
    val price :String
)

