package com.example.donuts_app.screens.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.donuts_app.R
import com.example.donuts_app.ui.theme.PinkBackground
import com.example.donuts_app.ui.theme.SecondaryColor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getAllTodayOffer()

    }

    fun onClickFav(donutName: String) {
        _state.update { currentState ->
            val updatedTodayOffers = currentState.todayOffers.map { donut ->
                if (donut.donutName == donutName) {
                    donut.copy(isFav = !donut.isFav) // Toggle the favorite status
                } else {
                    donut
                }
            }

            currentState.copy(todayOffers = updatedTodayOffers)
        }
    }

    private fun getAllTodayOffer() {
        _state.update {
            it.copy(
                todayOffers = listOf(
                    DonutUiState(
                        R.drawable.donuts,
                        "Strawberry Wheel",
                        "These Baked Strawberry Donuts are filled" +
                                " with fresh strawberries...",
                        "\$20",
                        "\$16",
                        SecondaryColor
                    ),
                    DonutUiState(
                        R.drawable.donut_7,
                        "Chocolate Glaze",
                        "Moist and fluffy baked chocolate donuts full of" +
                                " chocolate flavor.",
                        "\$20",
                        "\$16", PinkBackground),
                    DonutUiState(R.drawable.donuts ,"Strawberry Wheel2"
                        ,"These Baked Strawberry Donuts are filled" +
                                " with fresh strawberries...","\$20",
                        "\$16",SecondaryColor),
                    DonutUiState(R.drawable.donut_7 ,"Chocolate Glaze2"
                        ,"Moist and fluffy baked chocolate donuts full of" +
                                " chocolate flavor.","\$20",
                        "\$16",PinkBackground),
                    DonutUiState(R.drawable.donuts ,"Strawberry Wheel3"
                        ,"These Baked Strawberry Donuts are filled" +
                                " with fresh strawberries...","\$20",
                        "\$16",SecondaryColor),
                    DonutUiState(R.drawable.donut_7 ,"Chocolate Glaze3"
                        ,"Moist and fluffy baked chocolate donuts full of" +
                                " chocolate flavor.","\$20",
                        "\$16",PinkBackground),


                ),
                donuts = listOf(
                    DonutsUiState(R.drawable.donut_3,"Chocolate Cherry","\$22"),
                    DonutsUiState(R.drawable.donut_4,"Strawberry Rain","\$22"),
                    DonutsUiState(R.drawable.donuts_10,"Strawberry Coco","\$22"),
                    DonutsUiState(R.drawable.donut_3,"Chocolate Cherry","\$22"),
                    DonutsUiState(R.drawable.donut_4,"Strawberry Rain","\$22"),
                    DonutsUiState(R.drawable.donuts_10,"Strawberry Coco","\$22"),
                    DonutsUiState(R.drawable.donut_3,"Chocolate Cherry","\$22"),
                    DonutsUiState(R.drawable.donut_4,"Strawberry Rain","\$22"),
                    DonutsUiState(R.drawable.donuts_10,"Strawberry Coco","\$22"),




                    )
            )
        }

    }

}