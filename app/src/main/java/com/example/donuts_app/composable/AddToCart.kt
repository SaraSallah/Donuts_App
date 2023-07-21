package com.example.donuts_app.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.donuts_app.R
import com.example.donuts_app.navigation.BottomBarScreen
import com.example.donuts_app.screens.add_to_cart.AddFavourite
import com.example.donuts_app.screens.add_to_cart.AddToCartViewModel
import com.example.donuts_app.ui.theme.Background
import com.example.donuts_app.ui.theme.Black60
import com.example.donuts_app.ui.theme.Black80
import com.example.donuts_app.ui.theme.PrimaryColor
import com.example.donuts_app.ui.theme.White60

@Composable
fun Donut(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Background),
    ) {
        ReusableImage(image = R.drawable.donuts)
    }
    Row(
        modifier = Modifier
            .background(Background)
            .padding(top = 25.dp, start = 25.dp)
    )
    {
    ReusableICon(R.drawable.ic_round_arrow_back_ios,
        onClick = { navController.navigate(BottomBarScreen.Home.route)})
    }

}

@Composable
fun BottomCard(
    navController: NavController,
    viewModel: AddToCartViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    Box() {
        Card(
            modifier = Modifier
                .wrapContentSize()
                .wrapContentHeight()
                .offset((310).dp, (-35).dp),
            shape = RoundedCornerShape(size = 16.dp),
            colors = CardDefaults.cardColors(Color.White),
        ) {
            AddFavourite(onClick = {})
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.5f),
        shape = RoundedCornerShape(topStart = 32.dp , topEnd = 32.dp),
        colors = CardDefaults.cardColors(Color.White),

        ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp)
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.Start
                ){

            ReusableText(text = "Strawberry Wheel"
                , color = PrimaryColor, fontSize = 30.sp)
            SpacerVertical(height = 33.dp)
            ReusableText(text = "About Gonut",
                color = Black80
                , fontSize =18.sp )
            SpacerVertical(height = 16.dp)
            ReusableText(text = "These soft, cake-like Strawberry Frosted Donuts feature fresh " +
                    "strawberries and a delicious fresh strawberry glaze frosting. Pretty enough " +
                    "for company and the perfect treat to satisfy your sweet tooth."
                , color = Black60, fontSize = 14.sp
                , fontWeight = FontWeight.Normal)
            SpacerVertical(height = 16.dp)
            ReusableText(
                text = "Quantity"
                , color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Medium)
            SpacerVertical(height = 16.dp)
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp) ,
            verticalAlignment = Alignment.CenterVertically){
                ReusableQuantityCard(
                    text = "-", textColor = Color.Black, background = White60, fontSize = 32.sp,
                    onClick = viewModel::onClickMinusItem)
                ReusableQuantityCard(
                    text = "${state.count}", textColor = Color.Black, background = White60,
                    fontSize = 22.sp,){}
                ReusableQuantityCard(
                    text = "+", textColor = Color.White, background = Color.Black, fontSize = 32.sp,
                    onClick = viewModel::onClickPlusItem)
            }
            SpacerVertical(height = 50.dp)
            Row(){
                ReusableText(text = "£${+state.price}", color = Color.Black, fontSize = 30.sp)
                SpacerHorizontal(width = 26.dp)
                ReusableButton(
                    text = "Add To Cart",
                    textColor = Color.White ,
                    background = PrimaryColor ,
                    onClick = { navController.navigate(BottomBarScreen.Home.route)},
                    modifier = Modifier
                )

            }

        }

    }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewDonut(){
//    Donut()
    val navController = rememberNavController()
    BottomCard(navController)
}
