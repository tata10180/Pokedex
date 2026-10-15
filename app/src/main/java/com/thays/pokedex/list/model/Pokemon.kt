package com.thays.pokedex.list.model

data class Pokemon(val id: Long, val name: String, val imageUrl: String?)
//para o limit e offset
data class PokemonListResponse( val count: Int, val next: String?, val results: List<PokemonResult>)
//o que esta dentro do results
data class PokemonResult(val name: String, val url:String)
//e onde acha a id e o nome do pokemon, e os sprites
data class PokemonDetails(val id:Long, val name: String, val sprites: Sprites)

//aqui tem a imagem
data class Sprites(val other: Other)

data class Other(val official_artwork: OfficialArtwork)

data class OfficialArtwork(val front_default:String?)

//data class dos pokemons