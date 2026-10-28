package com.thays.pokedex.data.network

import com.thays.pokedex.data.PokemonDetails
import com.thays.pokedex.data.PokemonListResponse
import com.thays.pokedex.data.network.RetrofitClient.Companion.retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import kotlin.jvm.java


interface PokemonApiService {

    @GET("pokemon") //puxa todos os pokemons
    suspend fun getPokemonList(
        @Query("limit") limit: Int,//quantos pokemon vai puxar
        @Query("offset") offset: Int //a partir de qual posicao comeca

    ): PokemonListResponse

    @GET("pokemon/{name}") //puxa um pokemon especifico
    suspend fun getPokemon(@Path("name") name: String): PokemonDetails //isso usa dps na parte de detalhes

}

