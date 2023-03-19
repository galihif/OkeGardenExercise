package com.example.okegardenexercise.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RatingUlasanRow(
    rating:Double,
    ulasan:Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        StarIcon()
        StarIcon()
        StarIcon()
        StarIcon()
        StarIcon(true)
        Text("$rating", fontWeight = FontWeight.Bold, fontSize = 12.sp)
        Text("($ulasan Ulasan)", color = Color(0xFF4A4A4A), fontSize = 12.sp)
    }
}

@Composable
fun ButtonCheckoutCartRow(
    modifier: Modifier = Modifier,
    onCheckoutClick: () -> Unit,
    onCartClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Button(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp),
            onClick = onCheckoutClick,
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(
                    0xFF2D9556
                )
            )
        ) {
            Text(
                text = "Checkout",
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
        Button(
            onClick = onCartClick,
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Icon(
                imageVector = Icons.Outlined.AddShoppingCart,
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}