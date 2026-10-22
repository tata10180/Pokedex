package com.thays.pokedex.presentation.list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thays.pokedex.data.network.PokemonApiService
import com.thays.pokedex.data.repository.ListRepositoryImpl
import com.thays.pokedex.domain.repository.ListRepository

class ListViewModelFactory(private val api: PokemonApiService) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository: ListRepository = ListRepositoryImpl(api)
        return ListViewModel(repository) as T
    }
}