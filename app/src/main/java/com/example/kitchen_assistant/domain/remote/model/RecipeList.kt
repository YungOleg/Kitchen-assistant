package com.example.kitchen_assistant.domain.remote.model

import com.google.gson.annotations.SerializedName

data class RecipeList(
    @SerializedName("meals")
    val recipes: List<Recipe>
)