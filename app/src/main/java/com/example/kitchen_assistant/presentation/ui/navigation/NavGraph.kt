package com.example.kitchen_assistant.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.kitchen_assistant.presentation.ui.components.Screen
import com.example.kitchen_assistant.presentation.ui.screens.favourites.navigation.favouritesScreen
import com.example.kitchen_assistant.presentation.ui.screens.favourites_detail.navigation.favouritesDetailScreen
import com.example.kitchen_assistant.presentation.ui.screens.recipe_detail.navigation.recipeDetailScreen
import com.example.kitchen_assistant.presentation.ui.screens.recipes.navigation.recipesScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Recipes.route
    ) {
        favouritesScreen(navController)
        recipesScreen(navController)
        recipeDetailScreen(navController)
        favouritesDetailScreen(navController)
    }
}