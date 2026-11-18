package com.thays.pokedex.presentation.favorites

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thays.pokedex.R
import com.thays.pokedex.presentation.list.view.ListActivity
import com.thays.pokedex.presentation.themes.PokedexTheme
import com.thays.pokedex.presentation.themes.brown
import com.thays.pokedex.presentation.themes.heartRed


class FavoritePokemonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        FavoritePokemonLayout(
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(86.dp),
                            onBackClick = { finish() })
                    }
                }
            }

        }
    }

}

//fazer o compose da tela, so coloca uma tela vazia de favoritos por enquanto
@Composable
fun FavoritePokemonLayout(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Pokedex",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Row {
            FavoriteTopBar(onBackClick)
            Icon(
                painter = painterResource(R.drawable.ic_heart_full),
                contentDescription = "Favorite Heart ",
                tint = heartRed
            )
        }
    }
}

@Composable
fun FavoriteTopBar(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onBackClick) {
        Icon(
            painter = painterResource(R.drawable.ic_go_back),
            contentDescription = "Go back arrow",
            tint = brown

        )
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritePokemonLayoutPreview() {
    PokedexTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                FavoritePokemonLayout(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(76.dp),
                    onBackClick = {}
                )
            }
        }
    }
}

//coisas para fazer dps, o coracao esta menor, eu queria que eles ficassem mais
//o canto tb, entao eu tenho que pesquisar isso dps
//como fazer o espaco aumentar, qual o bug que faz aumentar o padding diminuir
//o coracao e eu quero o coracao mais perto do canto.
// ve se tira o compose da tela e joga a logica disso para outro lugar