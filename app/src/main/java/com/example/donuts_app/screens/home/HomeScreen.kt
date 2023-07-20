package com.example.donuts_app.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.donuts_app.R
import com.example.donuts_app.composable.LazyRowDonut
import com.example.donuts_app.composable.LazyRowDonutPrice
import com.example.donuts_app.composable.ReusableText
import com.example.donuts_app.composable.RoundedIconButton
import com.example.donuts_app.composable.SpacerHorizontal
import com.example.donuts_app.composable.SpacerVertical
import com.example.donuts_app.ui.theme.Background
import com.example.donuts_app.ui.theme.Black
import com.example.donuts_app.ui.theme.Black60
import com.example.donuts_app.ui.theme.PrimaryColor
import com.example.donuts_app.ui.theme.SecondaryTextColor

@JvmOverloads
@Composable
fun HomeScreen(navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val state by homeViewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 56.dp),
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
        LazyRowDonut(state = state
            ,navController = navController)

        SpacerVertical(height = 32.dp)
        Row() {
            SpacerHorizontal(width = 38.dp)

            ReusableText(text = "Donut", color = Black60, fontSize = 20.sp)
        }
        SpacerVertical(height = 32.dp)
        Row() {
            LazyRowDonutPrice(state = state,navController=navController)

//            LazyRowDonuts()

        }


    }


}
