package com.example.kitchen_assistant.data.remote.api

import com.example.kitchen_assistant.domain.remote.model.RecipeList
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipesApi {

    @GET("lookup.php")
    suspend fun getRecipeById(@Query("i") id: String): RecipeList

    @GET("random.php")
    suspend fun getRandomRecipe(): RecipeList

    @GET("search.php")
    suspend fun searchRecipe(@Query("s") s: String) : RecipeList
}