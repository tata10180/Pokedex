package com.thays.pokedex

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thays.pokedex.RetrofitClient.Companion.retrofit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListViewModel: ViewModel() {
    private val mutablePokemons :
        MutableLiveData<ArrayList<Pokemon>> by lazy{
            MutableLiveData<ArrayList<Pokemon>>()
        }
    val pokemons = MutableLiveData<String>().apply{}
    //val pokemon = mutablePokemons.asStateFlow()
    //val service = retrofit.create(PokemonApiService:: class.java)

    //private fun getPokemon(){
      //  viewModelScope.launch{
          //  val pokemonList = PokemonApi.retrofitService.getPokemon()
        //}
    }
}

//tirar mutable pokemon
//precisa colocar algo no getPokemon tp name ou limit,offset
//service nao e usado
//o resultado ainda nao atualiza o estado
//quem chama getPokemon