package com.example.kitchen_assistant.domain.remote.usecase

data class RecipeUseCases(
    val getRecipeInformationUseCase: GetRecipeInformationUseCase,
    val getRandomRecipeUseCase: GetRandomRecipeUseCase,
    val searchRecipe: SearchRecipe
)