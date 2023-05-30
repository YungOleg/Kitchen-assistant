package com.example.kitchen_assistant.presentation.ui.screens.favourites.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.kitchen_assistant.presentation.ui.components.Screen
import com.example.kitchen_assistant.presentation.ui.screens.FavouritesScreen

fun NavGraphBuilder.favouritesScreen(navController: NavHostController) {
    composable(Screen.Favourites.route){
        FavouritesScreen(navController)
    }
}