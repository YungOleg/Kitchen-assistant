package com.example.kitchen_assistant.presentation.ui.screens.favourites_detail.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kitchen_assistant.presentation.ui.theme.onSurfaceColor
import com.example.kitchen_assistant.presentation.ui.theme.poppins_regular
import com.example.kitchen_assistant.presentation.ui.theme.surfaceColor

@Composable
fun FavouritesDetailTopBar(
    navController: NavHostController
) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = onSurfaceColor
    ) {
        IconButton(
            modifier = Modifier.fillMaxHeight(),
            onClick = {
                navController.navigateUp()
            }
        ) {
            Icon(
                Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                tint = surfaceColor
            )
        }
        Text(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            text = "Favourite",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = surfaceColor,
            fontFamily = poppins_regular,
        )
    }
}