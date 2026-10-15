package com.thays.pokedex.list.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thays.pokedex.databinding.ActivityListBinding
import com.thays.pokedex.list.viewmodel.ListViewModel
import com.thays.pokedex.list.viewmodel.PokemonUiState

class ListActivity : AppCompatActivity() {

     private val viewModel: ListViewModel by viewModels() //mmudar para lateinit?
     private lateinit var binding: ActivityListBinding //precisa fazer binding aqui, e conectar, nao lembro como..
     private lateinit var pokemonAdapter: PokemonListAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //iniciar aqui
        pokemonAdapter = PokemonListAdapter()
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
       //tirar o mocked list, por que loadPokemon deu erro?

        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        observeViewModel()

        recyclerView.adapter = pokemonAdapter


        ViewCompat.setOnApplyWindowInsetsListener(recyclerView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    private fun observeViewModel(){
        viewModel.uiState.observe(this) { state ->
            when (state) {
                is PokemonUiState.Success -> {
                    pokemonAdapter.pokemonList = state.pokemons
                    pokemonAdapter.notifyDataSetChanged()
                }

                is PokemonUiState.Error -> {
                   Toast.makeText(this, state.message, Toast.LENGTH_LONG).show()
                }

                PokemonUiState.Loading -> {

                }
            }
        }
        viewModel.loadPokemon(20,0)


    }
}
//     val mockedList:List<Pokemon> = listOf(
//        Pokemon(1, "Pikachu", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png"),
//        Pokemon(2, "Charmander", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/shiny/4.png"),
//        Pokemon(3, "Squirtle", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/7.png"),
//        Pokemon(4, "Jigglypuff", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/39.png"),
//         Pokemon(5, "Mamoswine", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/473.png")
//     )//

//deu erro, perguntar para android daqui a pouco