package com.example.kitchen_assistant.domain.repository

import com.example.kitchen_assistant.domain.remote.model.RecipeList
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    suspend fun getRecipeInformation(id: String): RecipeList
    suspend fun getRandomRecipe(): RecipeList
    suspend fun searchRecipe(s: String): RecipeList
}