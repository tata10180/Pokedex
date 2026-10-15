package com.thays.pokedex.list.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thays.pokedex.list.model.ListRepository
import com.thays.pokedex.list.model.Pokemon
import com.thays.pokedex.list.network.PokemonApi
import kotlinx.coroutines.launch

sealed class PokemonUiState{
    object Loading: PokemonUiState()
    data class Success(val pokemons: List<Pokemon>): PokemonUiState()
    data class Error(val message:String): PokemonUiState()
}

class ListViewModel(): ViewModel() {

    private val repository = ListRepository(PokemonApi.retrofitService)

    private val _uiState = MutableLiveData<PokemonUiState>()
    val uiState: LiveData<PokemonUiState> = _uiState

    fun loadPokemon(limit: Int, offset: Int){
        viewModelScope.launch{
            _uiState.value = PokemonUiState.Loading
            try {
                val pokemons = repository.getPokemonList(20, 0)
                _uiState.value = PokemonUiState.Success(pokemons)
            } catch (e: Exception) {
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