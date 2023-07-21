package com.example.donuts_app.screens.add_to_cart

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AddToCartViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(AddToCartUiState())
    val state = _state.asStateFlow()
    fun onClickPlusItem() {
        _state.update { currentState ->
            currentState.copy(
                count = currentState.count + 1,
                price = (currentState.count + 1) * 16
            )
        }
    }

    fun onClickMinusItem() {
        _state.update { currentState ->
            if (currentState.count > 1) {
                currentState.copy(
                    count = currentState.count - 1,
                    price = (currentState.count - 1) * 16
                )
            } else {
                currentState
            }
        }
    }









}