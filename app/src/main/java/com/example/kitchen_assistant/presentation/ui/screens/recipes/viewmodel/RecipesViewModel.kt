package com.example.kitchen_assistant.presentation.ui.screens.recipes.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kitchen_assistant.domain.remote.model.Recipe
import com.example.kitchen_assistant.domain.remote.model.RecipeList
import com.example.kitchen_assistant.domain.remote.usecase.RecipeUseCases
import com.example.kitchen_assistant.presentation.ui.screens.recipes.components.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    private val recipeUseCases: RecipeUseCases
) : ViewModel() {

    private val _state = mutableStateOf(RecipeListState())
    val state: State<RecipeListState> = _state

    private val _displayingRecipes = MutableStateFlow(mutableListOf<Recipe>())
    val displayingRecipes = _displayingRecipes

    // For search bar
    private val _searchState: MutableState<SearchState> =
        mutableStateOf(SearchState.CLOSED)
    val searchState: State<SearchState> = _searchState
    private val _searchTextState: MutableState<String> =
        mutableStateOf("")
    val searchTextState: State<String> = _searchTextState
    fun updateSearchState(newValue: SearchState) {
        _searchState.value = newValue
    }
    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }

    init {
        updateDisplayingRecipes()
    }

    fun refreshRecipes() {
        viewModelScope.launch {
            _state.value.isLoading = true

            updateDisplayingRecipes()
            delay(1500)
            _state.value.isLoading = false
        }
    }

    fun getRandomRecipe() {
        viewModelScope.launch {
            recipeUseCases.getRandomRecipeUseCase.invoke()
        }
    }

    private fun updateDisplayingRecipes() {
        viewModelScope.launch {
            try {
                displayingRecipes.emit(mutableListOf())
                repeat(10) {
                    runBlocking {
                        val displayingRecipes = _displayingRecipes.value
                        displayingRecipes.add(
                            recipeUseCases.getRandomRecipeUseCase.invoke().recipes.first()
                        )
                        _displayingRecipes.emit(displayingRecipes)
                    }
                }
            } catch (e: Exception) {
                Log.e("[ERROR]", "displaying recipe error", e)
            }
        }
    }

    fun searchRecipe(s: String) {
        viewModelScope.launch {
            try {
                displayingRecipes.emit(mutableListOf())
                _displayingRecipes.emit(recipeUseCases.searchRecipe.invoke(s).recipes.toMutableList())
            } catch (e: Exception) {
                Log.e("[ERROR]", "search recipe error", e)
            }
        }
    }

    fun getRecipeInfo(id: String) {
        viewModelScope.launch {
            recipeUseCases.getRecipeInformationUseCase.invoke(id)
        }
    }

}

data class RecipeListState(
    var isLoading: Boolean = false,
    val recipeResponse: List<RecipeList> = emptyList(),
    val error: String = "",
)