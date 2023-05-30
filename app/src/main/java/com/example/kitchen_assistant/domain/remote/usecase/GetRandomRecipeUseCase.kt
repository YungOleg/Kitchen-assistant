package com.example.kitchen_assistant.domain.remote.usecase

import com.example.kitchen_assistant.domain.remote.model.RecipeList
import com.example.kitchen_assistant.domain.repository.RecipeRepository

class GetRandomRecipeUseCase(
    private val repository: RecipeRepository
) {
    suspend fun invoke() = try {
        repository.getRandomRecipe()
    } catch (_: Exception) {
        RecipeList(emptyList())
    }
}