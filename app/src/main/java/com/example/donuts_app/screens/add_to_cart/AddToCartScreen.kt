package com.example.donuts_app.screens.add_to_cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.donuts_app.R
import com.example.donuts_app.composable.BottomCard
import com.example.donuts_app.composable.Donut
import com.example.donuts_app.ui.theme.PrimaryColor

@Composable
fun AddToCartScreen(navController: NavController){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Donut()
        Column {
            AddFavourite()
            Spacer(modifier = Modifier.weight(1f))
            BottomCard()
        }
    }

}

@Composable
fun AddFavourite() {
    Card(
        shape = CircleShape,
        modifier = Modifier
            .background(Color.White)
            .size(50.dp)
            .offset((335).dp, (333).dp),
    ) {
        Box(
            modifier = Modifier.background(Color.White),
            contentAlignment = Alignment.Center,
        ) {
            IconButton(
//                modifier = Modifier.background(Color.White),

                onClick = { /* Handle icon click */ },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.fav),
                    tint = PrimaryColor, contentDescription = "",
                )
            }
        }
    }
}
