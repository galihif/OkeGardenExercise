package com.example.okegardenexercise.ui.screen.detail_produk

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.okegardenexercise.R
import com.example.okegardenexercise.ui.components.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailProdukScreen(
    onBackClicked: () -> Unit,
) {
    var quantity by remember { mutableStateOf(0) }
    var isFavorite by remember { mutableStateOf(false) }
    Scaffold() {
        Box(
            modifier = Modifier.wrapContentSize()
        ) {
            Image(
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.hampers), contentDescription = ""
            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                        .weight(1f),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = onBackClicked) {
                            Icon(imageVector = Icons.Default.ArrowBackIos, contentDescription = "")
                        }
                        Text(
                            "Detail Produk",
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1.8f),
                    elevation = 0.dp,
                    shape = RoundedCornerShape(24.dp, 24.dp, 0.dp, 0.dp),
                    backgroundColor = Color(0xFFC1E3D8)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CategoryCard(title = "Hampers Lebaran")
                            IconButton(onClick = { isFavorite = !isFavorite }) {
                                Icon(
                                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder,
                                    contentDescription = ""
                                )
                            }
                        }
                        Text(
                            text = "Hampers Type A",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            style = MaterialTheme.typography.h6
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RatingSoldText(rating = 4.5, sold = 8)
                            Text(
                                text = "IDR 115.000",
                                fontWeight = FontWeight.Bold
                            )
                        }
                        AddRemoveQuantityButton(
                            modifier = Modifier.align(Alignment.End),
                            quantity = quantity,
                            onAdd = {
                                quantity++
                            },
                            onRemove = {
                                if (quantity > 0) {
                                    quantity--
                                }
                            }
                        )
                        DeskripsiColumn()
                        UlasanCard()
                        ButtonCheckoutCartRow(
                            onCheckoutClick = { /*TODO*/ },
                            onCartClick = { /*TODO*/ }
                        )
                    }
                }
            }
        }
    }
}