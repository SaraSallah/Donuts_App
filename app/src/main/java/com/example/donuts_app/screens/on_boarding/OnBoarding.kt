package com.example.donuts_app.screens.on_boarding

import android.icu.number.Scale
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.donuts_app.R
import com.example.donuts_app.composable.ReusableButton
import com.example.donuts_app.composable.ReusableImage
import com.example.donuts_app.composable.ReusableText
import com.example.donuts_app.composable.SpacerVertical
import com.example.donuts_app.navigation.Screen
import com.example.donuts_app.ui.theme.Background
import com.example.donuts_app.ui.theme.PrimaryColor

@Composable
fun OnBoardingScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(modifier = Modifier.fillMaxWidth(1.6f)){
            ReusableImage(image = R.drawable.img_1)
        }

        Column(
            modifier = Modifier.padding(horizontal = 36.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(horizontalAlignment = Alignment.Start
            ) {
                ReusableText(
                    text = stringResource(R.string.gonuts_with_donuts),
                    color = PrimaryColor,
                    fontSize = 54.sp,
                    fontWeight = FontWeight.SemiBold
                )
                SpacerVertical(height = 8.dp)
                ReusableText(
                    text = "Donut",
                    color = PrimaryColor,
                    fontSize = 54.sp,
                    fontWeight = FontWeight.SemiBold,
                )
                SpacerVertical(height = 20.dp)
            }


            ReusableText(
                text = stringResource(R.string.on_boarding_String),
                color = PrimaryColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            SpacerVertical(height = 60.dp)

            ReusableButton(
                stringResource(R.string.get_started),
                Color.Black, Color.White,
                onClick = {navController.navigate(Screen.HomeScreen.route)},
                modifier = Modifier,
            )
            SpacerVertical(height = 46.dp)


        }

    }
}
