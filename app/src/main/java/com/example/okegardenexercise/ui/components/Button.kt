package com.example.okegardenexercise.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyTextButton(
    text:String,
) {
    TextButton(onClick = { /*TODO*/ }) {
        Text(
            text = text,
            color = Color(0xFF4A4A4A),
            fontSize = 12.sp
        )
        Icon(
            modifier = Modifier.size(12.dp),
            imageVector = Icons.Default.ArrowForwardIos,
            contentDescription = "",
            tint = Color(0xFF4A4A4A)
        )
    }
}

@Composable
fun AddRemoveQuantityButton(
    modifier: Modifier = Modifier,
    quantity: Int,
    onAdd: () -> Unit,
    onRemove: () -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ){
        Card(
            modifier = Modifier.clickable { onRemove() },
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color(0xFF2D9556)
        ){
            Icon(
                imageVector = Icons.Filled.Remove,
                contentDescription = "",
                tint = Color.White
            )
        }
        Text(quantity.toString())
        Card(
            modifier = Modifier.clickable { onAdd() },
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color(0xFF2D9556)
        ){
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "",
                tint = Color.White
            )
        }
    }
}