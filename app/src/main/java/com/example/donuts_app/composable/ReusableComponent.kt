package com.example.donuts_app.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.donuts_app.ui.theme.PrimaryColor
import com.example.donuts_app.ui.theme.Type

@Composable
fun ReusableText(
    text: String,
    color: Color,
    fontSize: TextUnit,
    fontWeight: FontWeight = FontWeight.SemiBold,
) {
    Text(
        text = text,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        modifier = Modifier.wrapContentSize(),

    )

}

@Composable
fun CustomText(
    text: String,
    color: Color,
    fontSize: TextUnit,
    fontWeight: FontWeight = FontWeight.SemiBold,
) {
    Text(
        text = text,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        modifier = Modifier.wrapContentSize(),
        textDecoration = TextDecoration.LineThrough

    )

}


@Composable
fun ReusableButton(
    text: String,
    textColor: Color,
    background: Color,
    onClick: () -> Unit,
    modifier: Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(),
        colors = ButtonDefaults
            .buttonColors(background),
        contentPadding = PaddingValues(16.dp)
    ) {

        Text(
            text,
            color = textColor,
            style = Type.text_20,
            modifier = modifier
        )
    }
}

@Composable
fun ReusableImage(
    image: Int,
    ) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ReusableICon(icon: Int ,
onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
    ) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = "",
        tint = PrimaryColor,
        modifier = Modifier
            .size(30.dp)
    )
}
}

@Composable
fun ReusableQuantityCard(
    text: String,
    textColor: Color,
    background: Color,
    fontSize: TextUnit,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.size(45.dp).clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = background),
        shape = RoundedCornerShape(15.dp),

    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center

        ) {
            ReusableText(
                text = text, color = textColor, fontSize = fontSize)

        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTextStyle() {
    ReusableQuantityCard(
        text = "-", textColor = Color.White, background = Color.Black, fontSize = 32.sp,{})
//    ReusableImage(image = R.drawable.donuts)
//    ReusableICon(R.drawable.ic_round_arrow_back_ios)

//
//    ReusableButton("dddddddddddd", Color.Black, Color.White, {}, modifier = Modifier)
}