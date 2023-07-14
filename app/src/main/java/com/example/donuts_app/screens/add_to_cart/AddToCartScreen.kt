package com.example.donuts_app.screens.add_to_cart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.donuts_app.composable.BottomCard
import com.example.donuts_app.composable.Donut

@Composable
fun AddToCartScreen(){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Donut()
        Column() {
            Spacer(modifier = Modifier.weight(1f))
            BottomCard()
        }
    }

}
@Preview(showBackground = true)
@Composable
fun PreviewAddToCartScreen(){
    AddToCartScreen()


}
