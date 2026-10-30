package com.thays.pokedex.data.mapper

import com.thays.pokedex.data.PokemonDetails
import com.thays.pokedex.data.PokemonResult
import com.thays.pokedex.domain.model.Pokemon

fun PokemonResult.toDomain(): Pokemon {
    val id = url.split("/").filter { it.isNotEmpty() }.last().toLong()
    return Pokemon(
        id,
        name,
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
    )
}

fun PokemonDetails.toDomain(): Pokemon {
    //val details = getPokemon(name)
    return Pokemon(
        id,
        name ,
        imageUrl = sprites.other.official_artwork.front_default
    )

}
//isso e uma extension