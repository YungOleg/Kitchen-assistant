package com.example.kitchen_assistant.presentation.ui.screens.recipe_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.kitchen_assistant.domain.local.model.Favourites
import com.example.kitchen_assistant.presentation.ui.components.FavoriteButton
import com.example.kitchen_assistant.presentation.ui.components.RatingBar
import com.example.kitchen_assistant.presentation.ui.screens.favourites_detail.viewmodel.FavouritesDetailViewModel
import com.example.kitchen_assistant.presentation.ui.screens.recipe_detail.components.RecipeDetailTopBar
import com.example.kitchen_assistant.presentation.ui.screens.recipe_detail.components.TextItem
import com.example.kitchen_assistant.presentation.ui.screens.recipe_detail.viewmodel.RecipeDetailViewModel
import com.example.kitchen_assistant.presentation.ui.theme.onSurfaceColor
import com.example.kitchen_assistant.presentation.ui.theme.poppins_regular
import com.example.kitchen_assistant.presentation.ui.theme.surfaceColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouritesDetailScreen(
    navController: NavHostController,
    id: String,
    name: String,
    instruction: String,
    ingredients: String,
    imageUrl: String,
    rating: Int
) {

    val viewModel: FavouritesDetailViewModel = hiltViewModel()
    val state by viewModel.state

    var currentRating by remember { mutableStateOf(rating) }

    Scaffold(
        topBar = {
            RecipeDetailTopBar(
                navController = navController
            )
        },
        containerColor = surfaceColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding() + 6.dp
                )
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(vertical = 6.dp))
            ImageItem(
                imageUrl = imageUrl,
                isDelete = state.isDelete,
                onClick = {
                    state.isDelete = !state.isDelete
                    val favourites = Favourites(
                        id = id.toInt(),
                        name = name,
                        instructions = instruction,
                        imageUrl = imageUrl,
                        ingredients = ingredients,
                        rating = currentRating
                    )

                    if (state.isDelete) {
                        viewModel.insertFavourite(
                            favourites
                        )
                    } else {
                        viewModel.deleteFavourite(
                            favourites
                        )
                    }
                }
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.5f),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = poppins_regular,
                        color = onSurfaceColor,
                        modifier = Modifier.padding(top = 6.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RatingBar(
                        rating = currentRating,
                        onRatingChanged = { newRating ->
                            currentRating = newRating
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.padding(top = 6.dp))
            TextItem(
                title = "Ingredients",
                text = ingredients
            )
            TextItem(
                title = "Steps",
                text = instruction
            )
        }
    }
}

