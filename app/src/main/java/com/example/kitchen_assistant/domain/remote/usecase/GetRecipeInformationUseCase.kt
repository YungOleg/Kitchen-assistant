package com.example.kitchen_assistant.domain.remote.usecase

import com.example.kitchen_assistant.domain.repository.RecipeRepository

class GetRecipeInformationUseCase(
    private val repository: RecipeRepository
) {
    suspend fun invoke(id: String) = try {
        repository.getRecipeInformation(id)
    } catch (_: Exception) { }
}