package com.example.donuts_app.composable

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.donuts_app.R
import com.example.donuts_app.navigation.BottomBarScreen
import com.example.donuts_app.screens.home.DonutUiState
import com.example.donuts_app.screens.home.HomeUiState
import com.example.donuts_app.screens.home.HomeViewModel
import com.example.donuts_app.ui.theme.Black
import com.example.donuts_app.ui.theme.Black60
import com.example.donuts_app.ui.theme.Black80
import com.example.donuts_app.ui.theme.PrimaryColor

@JvmOverloads
@Composable
fun LazyRowOffers(
    homeViewModel: HomeViewModel = hiltViewModel(),
    navController: NavController,
) {
    val state by homeViewModel.state.collectAsState()
    LazyRowDonut(state = state, navController = navController)
}

@Composable
fun LazyRowDonut(
    state: HomeUiState,
    navController: NavController,
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(325.dp),
        contentPadding = PaddingValues(horizontal = 32.dp),
        horizontalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        items(state.todayOffers) {
            DonutCard(
                state = it, navController = navController
            )
        }
    }
}
@Composable
fun DonutCard(
    state: DonutUiState,
    navController: NavController,
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .height(325.dp)
            .width(195.dp)
            .clickable {},

        contentAlignment = Alignment.Center
    ) {
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { navController.navigate(BottomBarScreen.AddToCartScreen.route) },
                colors = CardDefaults.cardColors(state.colorBackGround)
            ) { }
            Card(shape = CircleShape,
                modifier = Modifier.offset((-60).dp, (-120).dp)
        ) {
                Box(
                    modifier = Modifier.background(Color.White),
                    contentAlignment = Alignment.Center,
                ) {
                    IconButton(
                        onClick = { /* Handle icon click */ },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.fav),
                            tint = PrimaryColor, contentDescription = "",
                        )
                    }
                }
            }
        val rotationAngle = rememberInfiniteTransition().animateFloat(
            initialValue = 0f,
            targetValue = 180f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 2000,
                    easing = LinearEasing
                )
            )
        ).value


        Card(
            modifier = Modifier
                .size(180.dp)
                .offset(60.dp, (-50).dp)
                .background(Color.Transparent),
            colors = CardDefaults.cardColors(Color.Transparent)

        ) {

            Image(
                painter = rememberAsyncImagePainter(model = state.images),
//                painterResource(id = R.drawable.donuts),
//                rememberAsyncImagePainter(model = state.images),
                contentDescription = "category",
                modifier = Modifier.fillMaxSize().rotate(rotationAngle),
            )
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .padding(4.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))

            ReusableText(text = state.donutName, color = Black80, fontSize = 16.sp)
            SpacerVertical(height = 8.dp)

            ReusableText(
                text = state.donutDescription, color = Black60,
                fontSize = 12.sp, fontWeight = FontWeight.Normal
            )
            SpacerVertical(height = 4.dp)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

                CustomText(
                    text = state.oldPrice,
                    color = Black60, fontSize = 14.sp
                )
                SpacerHorizontal(width = 4.dp)

                ReusableText(
                    text = state.newPrice,
                    color = Black, fontSize = 22.sp
                )

            }

        }


    }
            }



@Composable
fun RoundedIconButton(
    color: Color,
    icon: Int,
) {
    Card(shape = RoundedCornerShape(16.dp)) {
        Box(
            modifier = Modifier
                .background(color),
            contentAlignment = Alignment.Center
        ) {
            IconButton(
                onClick = { /*TODO*/ },
            ) {
                ReusableICon(icon = icon, onClick = {})

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeComposable() {
//    DonutCard()

}
