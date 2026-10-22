package com.thays.pokedex.domain.repository

import com.thays.pokedex.domain.model.Pokemon

interface ListRepository { //acho que tudo deveria sair do domain n?

    suspend fun getPokemonList(limit: Int, offset: Int): List<Pokemon>

    suspend fun getPokemonFromDetails(name: String): Pokemon
}