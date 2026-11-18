package com.thays.pokedex.presentation.favorites

import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun PokemonCard(
    pokemonName: String,
    pokemonImageUrl: String?,
    isSaved: Boolean,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card() { }

}

@Preview(showBackground = true)
@Composable
fun PokemonCardPreview() {
    PokemonCard(pokemonName = "", pokemonImageUrl = "", isSaved = true, onSaveClick = {}, modifier = Modifier)
}