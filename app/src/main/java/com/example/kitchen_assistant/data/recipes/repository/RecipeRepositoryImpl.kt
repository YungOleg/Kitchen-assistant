package com.example.kitchen_assistant.data.recipes.repository

import com.example.kitchen_assistant.data.recipes.remote.api.RecipesApi
import com.example.kitchen_assistant.domain.remote.model.Recipe
import com.example.kitchen_assistant.domain.remote.model.RecipeList
import com.example.kitchen_assistant.domain.repository.RecipeRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class RecipeRepositoryImpl @Inject constructor(
    private val api: RecipesApi
): RecipeRepository{
    override suspend fun getRecipeInformation(id: String): RecipeList = try {
        api.getRecipeById(id)
    } catch (_: Exception) {
        RecipeList(emptyList())
    }
    override suspend fun getRandomRecipe(): RecipeList = try {
        api.getRandomRecipe()
    } catch (_: Exception) {
        RecipeList(emptyList())
    }
    override suspend fun searchRecipe(s: String): RecipeList = try {
        api.searchRecipe(s)
    } catch (_: Exception) {
        RecipeList(emptyList())
    }
}