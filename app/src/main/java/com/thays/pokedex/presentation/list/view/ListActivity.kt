package com.thays.pokedex.presentation.list.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thays.pokedex.R
import com.thays.pokedex.databinding.ActivityListBinding
import com.thays.pokedex.di.PokemonApplication
import com.thays.pokedex.presentation.list.viewmodel.ListViewModel
import com.thays.pokedex.presentation.list.viewmodel.ListViewModelFactory
import com.thays.pokedex.presentation.list.viewmodel.PokemonUiState

class ListActivity : AppCompatActivity() {
    //bsucar entender melhor dps o factoryproducer
    private val viewModel: ListViewModel by viewModels {
        val container = (application as PokemonApplication).container
        ListViewModelFactory(container.listRepository)
    }
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

    private fun observeViewModel() {
        viewModel.uiState.observe(this) { state ->
            when (state) {
                is PokemonUiState.Success -> {
                    pokemonAdapter.pokemonList = state.pokemons
                    pokemonAdapter.notifyDataSetChanged()
                    binding.loadingGif.visibility = View.GONE
                }

                is PokemonUiState.Error -> {
                    Toast.makeText(this, state.message, Toast.LENGTH_LONG).show()
                    binding.loadingGif.visibility = View.GONE
                }

                PokemonUiState.Loading -> {
                    Glide.with(this).asGif().load(R.drawable.ic_load_pokeball_speed).into(binding.loadingGif)
                    //binding.recyclerView.visibility=View.INVISIBLE
                    binding.loadingGif.visibility = View.VISIBLE
                }
            }
        }



    }
}


//deu erro, perguntar para android daqui a pouco