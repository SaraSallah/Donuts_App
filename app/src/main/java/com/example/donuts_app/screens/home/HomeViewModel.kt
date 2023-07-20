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
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
   val state =_state.asStateFlow()

   init {
       getAllTodayOffer()

   }
    private fun getAllTodayOffer(){
        _state.update {
            it.copy(
                todayOffers = listOf(
                    DonutUiState(R.drawable.donuts ,"Strawberry Wheel"
                        ,"These Baked Strawberry Donuts are filled" +
                                " with fresh strawberries...","\$20",
                        "\$16", SecondaryColor),
                    DonutUiState(R.drawable.donut_7 ,"Chocolate Glaze"
                        ,"Moist and fluffy baked chocolate donuts full of" +
                                " chocolate flavor.","\$20",
                        "\$16", PinkBackground),
                    DonutUiState(R.drawable.donuts ,"Strawberry Wheel"
                        ,"These Baked Strawberry Donuts are filled" +
                                " with fresh strawberries...","\$20",
                        "\$16",SecondaryColor),
                    DonutUiState(R.drawable.donut_7 ,"Chocolate Glaze"
                        ,"Moist and fluffy baked chocolate donuts full of" +
                                " chocolate flavor.","\$20",
                        "\$16",PinkBackground),
                    DonutUiState(R.drawable.donuts ,"Strawberry Wheel"
                        ,"These Baked Strawberry Donuts are filled" +
                                " with fresh strawberries...","\$20",
                        "\$16",SecondaryColor),
                    DonutUiState(R.drawable.donut_7 ,"Chocolate Glaze"
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