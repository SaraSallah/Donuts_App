package com.example.donuts_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.donuts_app.R
import com.example.donuts_app.composable.DefaultButton
import com.example.donuts_app.composable.ReusableText
import com.example.donuts_app.composable.SpacerVertical
import com.example.donuts_app.ui.theme.Background
import com.example.donuts_app.ui.theme.PrimaryColor

@Composable
fun OnBoardingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Column(
            modifier = Modifier.padding(horizontal = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ReusableText(
                text = stringResource(R.string.gonuts_with_donuts),
                color = PrimaryColor,
                fontSize = 54.sp,
                fontWeight = FontWeight.SemiBold
            )
            SpacerVertical(height = 20.dp)

            ReusableText(
                text = "Gonuts with Donuts is a Sri Lanka dedicated food outlets for specialize" +
                        " manufacturing of Donuts in Colombo, Sri Lanka",
                color = PrimaryColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            SpacerVertical(height = 60.dp)

            DefaultButton(
                stringResource(R.string.get_started),
                Color.Black, Color.White, {},
                modifier = Modifier
            )
            SpacerVertical(height = 46.dp)


        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewOnBoarding() {
    OnBoardingScreen()
}
