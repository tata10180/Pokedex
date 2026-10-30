package com.thays.pokedex.presentation.list.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thays.pokedex.domain.model.Pokemon
import com.thays.pokedex.domain.repository.ListRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed class PokemonUiState {
    object Loading : PokemonUiState()
    data class Success(val pokemons: List<Pokemon>) : PokemonUiState()
    data class Error(val message: String) : PokemonUiState()
}

class ListViewModel(private val repository: ListRepository) : ViewModel() {

    private val _uiState = MutableLiveData<PokemonUiState>()
    val uiState: LiveData<PokemonUiState> = _uiState

    init{loadPokemon(50, 10)}

    fun loadPokemon(limit: Int, offset: Int) {
        viewModelScope.launch {
            _uiState.value = PokemonUiState.Loading
            try {
                val pokemons = repository.getPokemonList(limit, offset)
                _uiState.value = PokemonUiState.Success(pokemons)
            } catch (e: IOException) {
                _uiState.value = PokemonUiState.Error(e.message ?: "Unknown error")
            }
        }
    }

}


//tirar mutable pokemon
//precisa colocar algo no getPokemon tp name ou limit,offset
//service nao e usado
//o resultado ainda nao atualiza o estado
//quem chama getPokemon
// val pokemon = mutablePokemons.asStateFlow()