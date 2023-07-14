package com.example.donuts_app.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.donuts_app.R
import com.example.donuts_app.composable.LazyRowDonuts
import com.example.donuts_app.composable.LazyRowOffers
import com.example.donuts_app.composable.ReusableText
import com.example.donuts_app.composable.RoundedIconButton
import com.example.donuts_app.composable.SpacerHorizontal
import com.example.donuts_app.composable.SpacerVertical
import com.example.donuts_app.ui.theme.Background
import com.example.donuts_app.ui.theme.Black
import com.example.donuts_app.ui.theme.Black60
import com.example.donuts_app.ui.theme.Black80
import com.example.donuts_app.ui.theme.PrimaryColor
import com.example.donuts_app.ui.theme.SecondaryTextColor

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top =56.dp ),
        horizontalAlignment = Alignment.Start,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 38.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                ReusableText(
                    text = "Let’s Gonuts!",
                    color = PrimaryColor, fontSize = 30.sp
                )
                ReusableText(
                    text = "Order your favourite donuts from here",
                    color = SecondaryTextColor,
                    fontSize = 14.sp
                )
            }
            RoundedIconButton(color = Background, icon = R.drawable.ic_search)
        }
        SpacerVertical(height = 24.dp)

        Row() {
            SpacerHorizontal(width = 38.dp)
            ReusableText(text = "Today Offer", color = Black, fontSize = 20.sp)

        }
        SpacerVertical(height = 24.dp)
        LazyRowOffers()

        SpacerVertical(height = 32.dp)
        Row() {
            SpacerHorizontal(width = 38.dp)

            ReusableText(text = "Donut", color = Black60, fontSize = 20.sp)
        }
        SpacerVertical(height = 32.dp)
        Row() {
            LazyRowDonuts()

        }


    }


}


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()

}