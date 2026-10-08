package com.thays.pokedex

import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClient {
    companion object {
        val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient().newBuilder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout( 10000L , TimeUnit.MILLISECONDS)
                .writeTimeout( 10000L , TimeUnit.MILLISECONDS).build())
    .build()
}
}