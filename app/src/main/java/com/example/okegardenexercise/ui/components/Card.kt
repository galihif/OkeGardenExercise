package com.example.okegardenexercise.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale.Category

@Composable
fun CategoryCard(
    title:String
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xFF2D9556)
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = title,
            color = Color.White,
            fontSize = 12.sp,
        )
    }
}

@Composable
fun UlasanCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        shape = RoundedCornerShape(16.dp, 0.dp, 16.dp, 0.dp),
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Rating Produk",
                fontWeight = FontWeight.Bold,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                RatingUlasanRow(rating = 4.5, ulasan = 8)
                MyTextButton(text = "Lihat Semua")
            }
        }
    }
}