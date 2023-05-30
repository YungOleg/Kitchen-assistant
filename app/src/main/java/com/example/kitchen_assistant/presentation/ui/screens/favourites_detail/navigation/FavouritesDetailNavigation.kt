package com.example.kitchen_assistant.presentation.ui.screens.favourites_detail.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.kitchen_assistant.presentation.ui.components.Screen
import com.example.kitchen_assistant.presentation.ui.screens.recipe_detail.FavouritesDetailScreen
import com.example.kitchen_assistant.presentation.ui.screens.recipe_detail.RecipeDetailScreen
import java.net.URLDecoder
import java.net.URLEncoder

fun NavGraphBuilder.favouritesDetailScreen(
    navController: NavHostController
) {
    composable(
        route = "${Screen.FAVOURITES_DETAIL_ROUTE}/" +
                "{id}/" +
                "{name}/" +
                "{instruction}/" +
                "{ingredients}/" +
                "{imageUrl}/" +
                "{rating}"
        ,
        arguments = listOf(
            navArgument("id") {
                type = NavType.StringType
                nullable = false
            },
            navArgument("name") {
                type = NavType.StringType
                nullable = false
            },
            navArgument("instruction") {
                type = NavType.StringType
                nullable = false
            },
            navArgument("ingredients") {
                type = NavType.StringType
                nullable = false
            },
            navArgument("imageUrl") {
                type = NavType.StringType
                nullable = false
            },
            navArgument("rating") {
                type = NavType.IntType
                nullable = false
            }
        )
    ) { backStackEntry ->
        val encodedId = backStackEntry.arguments?.getString("id")
        val encodedName = backStackEntry.arguments?.getString("name")
        val encodedInstruction = backStackEntry.arguments?.getString("instruction")
        val encodedIngredients = backStackEntry.arguments?.getString("ingredients")
        val encodedImageUrl = backStackEntry.arguments?.getString("imageUrl")

        val id = URLDecoder.decode(encodedId, "UTF-8")
        val name = URLDecoder.decode(encodedName, "UTF-8")
        val instruction = URLDecoder.decode(encodedInstruction, "UTF-8")
        val ingredients = URLDecoder.decode(encodedIngredients, "UTF-8")
        val imageUrl = URLDecoder.decode(encodedImageUrl, "UTF-8")
        val rating = backStackEntry.arguments?.getInt("rating")

        FavouritesDetailScreen(
            navController = navController,
            id = id ?: "",
            name = name ?: "",
            instruction = instruction ?: "",
            ingredients = ingredients?: "",
            imageUrl = imageUrl ?: "",
            rating = rating ?: 0
        )
    }
}