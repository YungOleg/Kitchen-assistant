package com.example.kitchen_assistant.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kitchen_assistant.R

@Composable
fun RatingBar(
    rating: Int = 0,
    stars: Int = 5,
    starsColor: Color = Color.Black,
    onRatingChanged: (Int) -> Unit
) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(stars) { index ->
            val isFilled = index < rating
            val starIcon = if (isFilled) {
                painterResource(R.drawable.field_star)
            } else {
                painterResource(R.drawable.border_star)
            }
            IconButton(onClick = {
                onRatingChanged(index + 1)
            },
                modifier = Modifier.size(32.dp)
            ) {
                Icon(
                    painter = starIcon,
                    contentDescription = null,
                    tint = starsColor,
                    modifier = Modifier.scale(
                        scale = 1.2f
                    )
                )
            }
        }
    }
}