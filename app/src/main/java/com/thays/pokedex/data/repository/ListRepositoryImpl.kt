package com.thays.pokedex.data.repository

import com.thays.pokedex.data.network.PokemonApiService
import com.thays.pokedex.domain.model.Pokemon
import com.thays.pokedex.domain.repository.ListRepository
import com.thays.pokedex.data.mapper.toDomain

class ListRepositoryImpl(private val api: PokemonApiService) : ListRepository {
     override suspend fun getPokemonList(limit: Int, offset: Int): List<Pokemon>{
         val response = api.getPokemonList(limit, offset)
            return response.results.map{
                result -> result.toDomain()
            }
//             val dto = api.getPokemonList(limit, offset)
//             dto.toDomain()

     }

    override suspend fun getPokemonFromDetails(name: String): Pokemon {
        val details = api.getPokemon(name)
        return details.toDomain()
         //por que nao precisa do ? depois do sprites

    }
}