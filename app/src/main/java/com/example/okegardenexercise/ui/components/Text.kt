package com.example.okegardenexercise.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun RatingSoldText(
    rating:Double,
    sold:Int
) {
    Row{
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "",
            tint = Color(0xFFE78923)
        )
        Text(
            text = "$rating",
        )
        Text(
            text = " | $sold Terjual",
        )
    }
}