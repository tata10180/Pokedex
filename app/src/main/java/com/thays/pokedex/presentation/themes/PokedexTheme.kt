package com.thays.pokedex.presentation.themes

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


    private val ColorSqueme = lightColorScheme(
        primary = yellow,
        background = light_bluegray
    )
    @Composable
    fun PokedexTheme(content: @Composable () -> Unit){
        MaterialTheme(
            colorScheme = ColorSqueme,
            typography = AppTypography,
            content = content
        )
    }
