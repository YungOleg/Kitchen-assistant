package com.example.kitchen_assistant.presentation.ui.screens.recipes

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.kitchen_assistant.presentation.ui.components.BottomNavigationBar
import com.example.kitchen_assistant.presentation.ui.components.ShimmerEffect
import com.example.kitchen_assistant.presentation.ui.screens.recipes.components.MainRecipeTopBar
import com.example.kitchen_assistant.presentation.ui.components.NoConnectionLottie
import com.example.kitchen_assistant.presentation.ui.screens.recipes.components.RecipeItem
import com.example.kitchen_assistant.presentation.ui.screens.recipes.components.SearchState
import com.example.kitchen_assistant.presentation.ui.screens.recipes.viewmodel.RecipesViewModel
import com.example.kitchen_assistant.presentation.ui.theme.surfaceColor
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesScreen(
    navController: NavHostController
) {
    val viewModel: RecipesViewModel = hiltViewModel()

    val searchState by viewModel.searchState
    val searchTextState by viewModel.searchTextState

    val swipeRefresh = rememberSwipeRefreshState(isRefreshing = viewModel.state.value.isLoading)
    val recipeList by viewModel.displayingRecipes.collectAsState()

//    val context = LocalContext.current
//    val connectivityManager =
//        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//    val network = connectivityManager.activeNetwork
//    val networkCapabilities = connectivityManager.getNetworkCapabilities(network)
//    val isConnected =
//        networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
//    val isInternetAvailable = isConnected || network != null

//    var showAnimation by remember { mutableStateOf(false) }
//
//    LaunchedEffect(Unit) {
//        if (recipeList.isEmpty()) {
//            showAnimation = true
//            delay(2000)
//            showAnimation = false
//        }
//    }
    Scaffold(
        topBar = {
            MainRecipeTopBar(
                searchState = searchState,
                searchTextState = searchTextState,
                onTextChange = {
                    viewModel.updateSearchTextState(it)
                },
                onClose = {
                    viewModel.updateSearchTextState("")
                    viewModel.updateSearchState(SearchState.CLOSED)
                },
                onSearchTriggered = {
                    viewModel.updateSearchState(SearchState.OPENED)
                },
                viewModel = viewModel
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        },
        containerColor = surfaceColor
    ) {
        if (recipeList.isNotEmpty()) {
            SwipeRefresh(
                state = swipeRefresh,
                onRefresh = {
                    viewModel.refreshRecipes()
                }
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            top = it.calculateTopPadding(),
                            bottom = it.calculateBottomPadding()
                        )
                ) {
                    items(
                        items = recipeList
                    ) { recipe ->
                        RecipeItem(
                            recipe = recipe,
                            navController = navController
                        )
                    }
                }
            }
        } else {
            SwipeRefresh(
                state = swipeRefresh,
                onRefresh = {
                    viewModel.refreshRecipes()
                }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            top = it.calculateTopPadding(),
                            bottom = it.calculateBottomPadding()
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    NoConnectionLottie()
                }
            }
        }
    }
}