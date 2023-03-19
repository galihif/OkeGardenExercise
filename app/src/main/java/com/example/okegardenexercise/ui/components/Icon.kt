package com.example.okegardenexercise.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StarIcon(
    isHalf:Boolean = false,
) {
    Icon(
        modifier = Modifier.size(16.dp),
        imageVector = if (isHalf) Icons.Default.StarHalf else Icons.Default.Star,
        contentDescription = "",
        tint = Color(0xFFE78923)
    )
}