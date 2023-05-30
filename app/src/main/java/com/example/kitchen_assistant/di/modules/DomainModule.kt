package com.example.kitchen_assistant.di.modules

import android.content.Context
import com.example.kitchen_assistant.data.recipes.repository.FavouritesRepositoryImpl
import com.example.kitchen_assistant.data.recipes.repository.RecipeRepositoryImpl
import com.example.kitchen_assistant.domain.local.usecase.DeleteFavouritesUseCase
import com.example.kitchen_assistant.domain.local.usecase.GetFavouritesUseCase
import com.example.kitchen_assistant.domain.local.usecase.InsertFavouritesUseCase
import com.example.kitchen_assistant.domain.local.usecase.FavouritesUseCases
import com.example.kitchen_assistant.domain.remote.usecase.GetRandomRecipeUseCase
import com.example.kitchen_assistant.domain.remote.usecase.GetRecipeInformationUseCase
import com.example.kitchen_assistant.domain.remote.usecase.RecipeUseCases
import com.example.kitchen_assistant.domain.remote.usecase.SearchRecipe
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun providesFavouritesUseCases(favouritesRepositoryImpl: FavouritesRepositoryImpl) =
        FavouritesUseCases(
            insertFavouritesUseCase = InsertFavouritesUseCase(favouritesRepositoryImpl),
            getFavouritesUseCase = GetFavouritesUseCase(favouritesRepositoryImpl),
            deleteFavouritesUseCase = DeleteFavouritesUseCase(favouritesRepositoryImpl)
        )

    @Provides
    fun providesRecipeUseCases(recipeRepositoryImpl: RecipeRepositoryImpl) =
        RecipeUseCases(
            getRecipeInformationUseCase = GetRecipeInformationUseCase(recipeRepositoryImpl),
            getRandomRecipeUseCase = GetRandomRecipeUseCase(recipeRepositoryImpl),
            searchRecipe = SearchRecipe(recipeRepositoryImpl)
        )
}