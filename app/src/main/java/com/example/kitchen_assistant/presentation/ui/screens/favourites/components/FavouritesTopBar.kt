package com.example.kitchen_assistant.presentation.ui.screens.favourites.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kitchen_assistant.presentation.ui.theme.SecondaryGreen
import com.example.kitchen_assistant.presentation.ui.theme.onSurfaceColor
import com.example.kitchen_assistant.presentation.ui.theme.poppins_regular
import com.example.kitchen_assistant.presentation.ui.theme.surfaceColor

@Composable
fun FavouritesTopBar() {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = onSurfaceColor
    ) {
        Text(
            modifier = Modifier
                .padding(12.dp)
                .weight(1f)
                .align(Alignment.CenterVertically),
            text = "Favourites",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = surfaceColor,
            fontFamily = poppins_regular
        )
    }
}