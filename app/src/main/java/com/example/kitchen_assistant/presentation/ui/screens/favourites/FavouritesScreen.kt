package com.example.kitchen_assistant.presentation.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.kitchen_assistant.presentation.ui.components.BottomNavigationBar
import com.example.kitchen_assistant.presentation.ui.screens.favourites.components.FavouritesTopBar
import com.example.kitchen_assistant.presentation.ui.screens.favourites.viewmodel.FavouritesViewModel
import com.example.kitchen_assistant.presentation.ui.screens.recipes.components.FavouritesItem
import com.example.kitchen_assistant.presentation.ui.screens.recipes.components.RecipeItem
import com.example.kitchen_assistant.presentation.ui.theme.surfaceColor
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouritesScreen(
    navController: NavHostController
) {

    val viewModel: FavouritesViewModel = hiltViewModel()
    val favouriteList = viewModel.favouriteList.collectAsState(initial = listOf())

    Scaffold(
        modifier = Modifier,
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        },
        topBar = {
            FavouritesTopBar()
        },
        containerColor = surfaceColor
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(
                    top = it.calculateTopPadding(),
                    bottom = it.calculateBottomPadding()
                )
        ) {
            items(
                items = favouriteList.value
            ) { favourite ->
                val deleteSwipe = SwipeAction(
                    onSwipe = {
                        viewModel.deleteFavourite(favourite)
                    },
                    icon = {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = null
                        )
                    },
                    background = Color.Red
                )
                SwipeableActionsBox(
                    endActions = listOf(deleteSwipe),
                    swipeThreshold = 210.dp,
                    backgroundUntilSwipeThreshold = Color.Red
                ) {
                    FavouritesItem(
                        favourites = favourite,
                        navController = navController
                    )
                }
            }
        }
    }
}