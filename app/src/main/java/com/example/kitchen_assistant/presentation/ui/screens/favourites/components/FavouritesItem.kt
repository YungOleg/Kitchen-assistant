package com.example.kitchen_assistant.presentation.ui.screens.recipes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.kitchen_assistant.domain.local.model.Favourites
import com.example.kitchen_assistant.domain.remote.model.Recipe
import com.example.kitchen_assistant.domain.remote.model.getString
import com.example.kitchen_assistant.presentation.ui.components.RatingBar
import com.example.kitchen_assistant.presentation.ui.components.Screen
import com.example.kitchen_assistant.presentation.ui.theme.surfaceColor
import java.net.URLEncoder

@Composable
fun FavouritesItem(
    favourites: Favourites,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(horizontal = 4.dp, vertical = 4.dp)
            .clickable {
                try {
                    val encodedId = URLEncoder.encode(favourites.id.toString(), "UTF-8")
                    val encodedName = URLEncoder.encode(favourites.name, "UTF-8")
                    val encodedInstruction = URLEncoder.encode(favourites.instructions, "UTF-8")
                    val encodedIngredients = URLEncoder.encode(favourites.ingredients, "UTF-8")
                    val encodedImageUrl = URLEncoder.encode(favourites.imageUrl, "UTF-8")
                    val rating = favourites.rating
                    navController.navigate(
                        "${Screen.FAVOURITES_DETAIL_ROUTE}/" +
                                "$encodedId/" +
                                "$encodedName/" +
                                "$encodedInstruction/" +
                                "$encodedIngredients/" +
                                "$encodedImageUrl/" + rating
                    )
                } catch (_: Exception) {}
            },
        shape = RoundedCornerShape(5),
        colors = CardDefaults.cardColors(
            containerColor = surfaceColor
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.4f)
                    .padding(vertical = 8.dp, horizontal = 4.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(favourites.imageUrl),
                    null,
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .fillMaxSize()
                        .clip(RoundedCornerShape(7)),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 8.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = favourites.name,
                    modifier = Modifier.padding(top = 12.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.padding(top = 6.dp))
                RatingBar(
                    rating = favourites.rating,
                    onRatingChanged = {}
                )
            }
        }
    }
}