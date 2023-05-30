package com.example.kitchen_assistant.presentation.ui.screens.recipes.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.kitchen_assistant.presentation.ui.components.Screen
import com.example.kitchen_assistant.presentation.ui.screens.recipes.RecipesScreen

fun NavGraphBuilder.recipesScreen(navController: NavHostController) {
    composable(Screen.Recipes.route) {
        RecipesScreen(navController)
    }
}