package com.thays.pokedex

import com.thays.pokedex.RetrofitClient.Companion.retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import kotlin.jvm.java


interface PokemonApiService {

    @GET("pokemon") //puxa todos os pokemons
    suspend fun getPokemonList(
        @Query("limit") limit: Int,//quantos pokemon vai puxar
        @Query("offset") offset: Int //a partir de qual posicao comeca

    ):List<Pokemon>

    @GET("pokemon/{name}") //puxa um pokemon especifico
    suspend fun getPokemon (@Path("name")name:String)

}

object PokemonApi{
    val retrofitService: PokemonApiService by lazy{
        retrofit.create(PokemonApiService::class.java)
    }
}