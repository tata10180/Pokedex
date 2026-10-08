package com.thays.pokedex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil3.load

class PokemonListAdapter(private val pokemonList: List<Pokemon> ):
    RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>(){

        class PokemonViewHolder(view: View): RecyclerView.ViewHolder(view){

            val textView: TextView
            val imageView: ImageView

            init{
                textView = view.findViewById(R.id.pokemon_name) //card de pokemon que eu preciso criar
                imageView = view.findViewById(R.id.pokemon_image)// card de pokemon que eu preciso criar
            }

            }
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PokemonViewHolder {
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.pokemon_card, viewGroup, false) //entender melhor isso aqui
    //o xml do layout de pokemon
            return PokemonViewHolder(view)//entender isso
        }
            override fun onBindViewHolder(viewHolder: PokemonViewHolder, position: Int ){
                val pokemon = pokemonList[position]

               viewHolder.textView.text = pokemon.name //--> caminho certo, trocar pelo nome do card pokecards
               viewHolder.imageView.load(pokemon.sprites)
                //colar as coisas, colar o objeto na view, cards iguais nao tem logica. so cards diferentes

            }
        override fun getItemCount():Int {
            return pokemonList.size
        } //saber quantos pokemons tem na lista

        }



//pesquisar mais sobre o fluxo e como ele funciona
//ate pq eu nao entendi como isso funciona, por que eu preciso fazer recyclerview.adapter
//e por que o class viewholder