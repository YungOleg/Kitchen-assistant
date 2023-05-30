package com.example.kitchen_assistant.presentation.ui.screens.recipes.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kitchen_assistant.R
import com.example.kitchen_assistant.presentation.ui.screens.recipes.viewmodel.RecipesViewModel
import com.example.kitchen_assistant.presentation.ui.theme.onSurfaceColor
import com.example.kitchen_assistant.presentation.ui.theme.poppins_light
import com.example.kitchen_assistant.presentation.ui.theme.poppins_regular
import com.example.kitchen_assistant.presentation.ui.theme.surfaceColor

@Composable
fun TopBar(
    onSearchTriggered: () -> Unit
) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = onSurfaceColor,
        title = {
            Text(
                modifier = Modifier
                    .padding(start = 4.dp, top = 2.dp),
                text = "Recipes",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = poppins_regular,
                color = surfaceColor
            )
        },
        actions = {
            IconButton(
                onClick = {
                    onSearchTriggered()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                    tint = surfaceColor
                )
            }
        }
    )
}


@Composable
fun SearchBar(
    text: String,
    onTextChange: (String) -> Unit,
    onClose: () -> Unit,
    viewModel: RecipesViewModel
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = onSurfaceColor
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            placeholder = {
                Text(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium),
                    text = "Search...",
                    fontFamily = poppins_light,
                    color = surfaceColor
                )
            },
            textStyle = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = poppins_regular,
                color = surfaceColor
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium),
                    onClick = {

                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = null,
                        tint = surfaceColor
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        if (text.isNotEmpty()) {
                            onTextChange("")
                        } else {
                            onClose()
                        }
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = null,
                        tint = surfaceColor
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    viewModel.searchRecipe(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = surfaceColor.copy(alpha = ContentAlpha.medium),
                focusedLabelColor = onSurfaceColor,
                unfocusedLabelColor = onSurfaceColor,
                focusedIndicatorColor = onSurfaceColor,
                unfocusedIndicatorColor = onSurfaceColor
            )
        )
    }
}

@Composable
fun MainRecipeTopBar(
    searchState: SearchState,
    searchTextState: String,
    onTextChange: (String) -> Unit,
    onClose: () -> Unit,
    onSearchTriggered: () -> Unit,
    viewModel: RecipesViewModel
) {
    when (searchState) {
        SearchState.CLOSED -> {
            TopBar(
                onSearchTriggered = onSearchTriggered
            )
        }
        SearchState.OPENED -> {
            SearchBar(
                text = searchTextState,
                onTextChange = onTextChange,
                onClose = onClose,
                viewModel = viewModel
            )
        }
    }
}