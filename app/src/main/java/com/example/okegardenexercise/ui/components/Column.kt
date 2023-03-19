package com.example.okegardenexercise.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DeskripsiColumn() {
    Column {
        Text(
            text = "Deskripsi",
            fontWeight = FontWeight.Bold,
        )
        Text(
            "1 Tanaman (Philodendron burle-marxii)",
            style = MaterialTheme.typography.body2,
            color = Color(0xFF4A4A4A),
        )
        Text(
            "1 Kartu Ucapan (Christmas/New Year)",
            style = MaterialTheme.typography.body2,
            color = Color(0xFF4A4A4A),
        )
        Text(
            "Care Tips",
            style = MaterialTheme.typography.body2,
            color = Color(0xFF4A4A4A),
        )
        Text(
            "Paper Bag",
            style = MaterialTheme.typography.body2,
            color = Color(0xFF4A4A4A),
        )
        Text(
            "Additional Cookies (Putri Salju/Choco Mede)",
            style = MaterialTheme.typography.body2,
            color = Color(0xFF4A4A4A),
        )
    }
}