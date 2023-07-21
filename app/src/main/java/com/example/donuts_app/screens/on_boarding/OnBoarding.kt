package com.example.donuts_app.screens.on_boarding

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.donuts_app.R
import com.example.donuts_app.composable.ReusableButton
import com.example.donuts_app.composable.ReusableImage
import com.example.donuts_app.composable.ReusableText
import com.example.donuts_app.composable.SpacerVertical
import com.example.donuts_app.navigation.BottomBarScreen
import com.example.donuts_app.navigation.LocalNavigationProvider
import com.example.donuts_app.ui.theme.Background
import com.example.donuts_app.ui.theme.PrimaryColor

@Composable
fun OnBoardingScreen() {
    val navController = LocalNavigationProvider.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        AnimatedImage(imageRes = R.drawable.img_1)


        Column(
            modifier = Modifier.padding(horizontal = 36.dp),
            horizontalAlignment = Alignment.Start
        ) {
                ReusableText(
                    text = "Gonuts\n" +
                            "with\n" +
                            "Donuts",
                    color = PrimaryColor,
                    fontSize = 54.sp,
                    fontWeight = FontWeight.SemiBold,
                )
                SpacerVertical(height = 20.dp)


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
                onClick = {navController.navigate(BottomBarScreen.Home.route)},
                modifier = Modifier,
            )
            SpacerVertical(height = 46.dp)


        }

    }
}
@Composable
fun AnimatedImage(imageRes: Int) {
    val imagePainter: Painter = painterResource(id = imageRes)
    val infiniteTransition = rememberInfiniteTransition()
    val scale by infiniteTransition.animateFloat(
        initialValue = 1.2f,
        targetValue = 1.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Image(
        painter = imagePainter,
        contentDescription = null,
        modifier = Modifier.scale(scale)
    )
}
@Preview(showBackground = true)
@Composable
fun PreviewOnBoarding(){
    OnBoardingScreen()
}
