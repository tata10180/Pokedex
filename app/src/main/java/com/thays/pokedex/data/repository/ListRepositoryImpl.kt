package com.thays.pokedex.data.repository

import com.thays.pokedex.data.network.PokemonApiService
import com.thays.pokedex.domain.model.Pokemon
import com.thays.pokedex.domain.repository.ListRepository

class ListRepositoryImpl(private val api: PokemonApiService) : ListRepository {
    override suspend fun getPokemonList(limit: Int, offset: Int): List<Pokemon> {
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

    override suspend fun getPokemonFromDetails(name: String): Pokemon {
        val details = api.getPokemon(name)
        return Pokemon(
            id = details.id,
            name = details.name,
            imageUrl = details.sprites.other.official_artwork.front_default
        ) //por que nao precisa do ? depois do sprites

    }
}