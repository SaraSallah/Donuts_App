package com.example.donuts_app.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.donuts_app.navigation.Screen
import com.example.donuts_app.screens.home.DonutsUiState
import com.example.donuts_app.screens.home.HomeUiState
import com.example.donuts_app.screens.home.HomeViewModel
import com.example.donuts_app.ui.theme.Black80
import com.example.donuts_app.ui.theme.PrimaryColor

@Composable
fun LazyRowDonuts(
    homeViewModel: HomeViewModel = hiltViewModel(),
    navController: NavController,
) {
    val state by homeViewModel.state.collectAsState()
    LazyRowDonutPrice(state = state, navController = navController)
}

@Composable
fun LazyRowDonutPrice(
    state: HomeUiState,
    navController: NavController,
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        contentPadding = PaddingValues(32.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(state.donuts) {
            DonutsCard(state = it, navController = navController)
        }
    }
}

@Composable
fun DonutsCard(
    state: DonutsUiState,
    navController: NavController,
) {
    Box(
        modifier = Modifier
            .width(138.dp)
            .height(120.dp), contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .clickable { navController.navigate(Screen.AddToCartScreen.route) },
            colors = CardDefaults.cardColors(Color.White)
        ) {
        }
        Card(
        modifier = Modifier
            .size(115.dp)
            .offset(0.dp, (-55).dp)
            .background(Color.Transparent),
        colors = CardDefaults.cardColors(Color.Transparent)

    ) {
        Image(
            painter = rememberAsyncImagePainter(model = state.images),

            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
        )
    }
        Column(
            modifier = Modifier
                .padding(4.dp) ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))

            ReusableText(text = state.donutName, color = Black80, fontSize = 14.sp)
            SpacerVertical(height = 8.dp)

            ReusableText(
                text = state.price, color = PrimaryColor,
                fontSize = 14.sp,
            )
            SpacerVertical(height = 4.dp)}

        }


}

@Preview(showBackground = true)
@Composable
fun PreviewDonutCard() {

}