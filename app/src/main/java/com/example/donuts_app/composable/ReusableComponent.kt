package com.example.donuts_app.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.donuts_app.ui.theme.Roboto
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
        fontFamily = Roboto
    )

}

@Composable
fun DefaultButton(
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
            modifier =modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTextStyle() {
//
    DefaultButton("dddddddddddd", Color.Black, Color.White, {}, modifier = Modifier)
}