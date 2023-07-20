package com.example.donuts_app.screens.add_to_cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
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
import androidx.navigation.compose.rememberNavController
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
        Column (){
//            AddFavourite()
            Spacer(modifier = Modifier.weight(1f))
            BottomCard(navController)
        }
    }

}

@Composable
fun AddFavourite(    onClick: () -> Unit,
) {
    IconButton(
        onClick = onClick,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.fav),
            tint = PrimaryColor,
            contentDescription = "stringResource(R.string.fav_icon)",
        )
}
}

@Preview(showBackground = true)
@Composable
fun PreviewCartScreen() {
    val navController = rememberNavController()
    AddToCartScreen(navController = navController)
}
