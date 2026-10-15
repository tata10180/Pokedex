package com.thays.pokedex.list.model

import com.thays.pokedex.list.network.PokemonApiService

class ListRepository(private val api: PokemonApiService) {

    suspend fun getPokemonList(limit: Int, offset: Int):List<Pokemon>{
        val response = api.getPokemonList(limit, offset)
        return response.results.map { result ->
            val id = result.url.split("/").filter { it.isNotEmpty() }.last().toLong()
            Pokemon(
                id,
                result.name,
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
            )
        }

    }
    suspend fun getPokemonFromDetails(name: String): Pokemon {
        val details = api.getPokemon(name)
        return Pokemon(
            id = details.id,
            name = details.name,
            imageUrl = details.sprites.other.official_artwork.front_default
        ) //por que nao precisa do ? depois do sprites

    }
}