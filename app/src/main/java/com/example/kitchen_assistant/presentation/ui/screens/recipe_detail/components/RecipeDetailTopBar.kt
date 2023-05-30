package com.example.kitchen_assistant.presentation.ui.screens.recipe_detail.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun RecipeDetailTopBar(
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
                // Update favourites
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
                .padding(top = 4.dp)
                .weight(1f)
                .align(Alignment.CenterVertically),
            text = "Recipe",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = surfaceColor,
            fontFamily = poppins_regular,
        )
    }
}