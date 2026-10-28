package com.thays.pokedex.data

import com.google.gson.annotations.SerializedName

//para o limit e offset
data class PokemonListResponse(val count: Int, val next: String?, val results: List<PokemonResult>) //isso e dto

//o que esta dentro do results
data class PokemonResult(val name: String, val url: String) //isso tb

//e onde acha a id e o nome do pokemon, e os sprites
data class PokemonDetails(val id: Long, val name: String, val sprites: Sprites) //o resto nao parece que vai no domain

//aqui tem a imagem
data class Sprites(val other: Other)

data class Other(@SerializedName("official-artwork") val official_artwork: OfficialArtwork)

data class OfficialArtwork(@SerializedName("front-default") val front_default: String?)

//data class dos pokemons