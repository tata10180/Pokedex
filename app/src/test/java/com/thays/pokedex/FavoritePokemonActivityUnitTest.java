package com.thays.pokedex;

public class FavoritePokemonActivityUnitTest {
}

//fazer o teste da seta de pokemon voltar para tela de pokemons
//copia esse teste
//@Test
//fun favorite_button_is_clicked() {
//    ActivityScenario.launch(ListActivity::class.java).use {
//        scenario -> scenario.onActivity {
//            activity -> activity.findViewById<ImageView>(R.id.favorite_heart).performClick()
//
//            val intent =  shadowOf(activity).nextStartedActivity
//
//            assertEquals(
//                    FavoritePokemonActivity::class.java.name,
//                    intent.component?.className
//            )
//        }
//    }
//}