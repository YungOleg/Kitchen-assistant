package com.example.kitchen_assistant.domain.remote.usecase

import com.example.kitchen_assistant.domain.remote.model.RecipeList
import com.example.kitchen_assistant.domain.repository.RecipeRepository

class SearchRecipe(
    private val repository: RecipeRepository
) {
    suspend fun invoke(s: String) = try {
        repository.searchRecipe(s)
    } catch (_: Exception) {
        RecipeList(emptyList())
    }
}