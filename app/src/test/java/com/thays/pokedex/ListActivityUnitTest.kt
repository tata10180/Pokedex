package com.thays.pokedex

import android.widget.ImageView
import androidx.test.core.app.ActivityScenario
import com.thays.pokedex.presentation.favorites.FavoritePokemonActivity
import com.thays.pokedex.presentation.list.view.ListActivity
import org.junit.Test

import org.junit.Assert.*
import org.robolectric.Shadows.shadowOf

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ListActivityUnitTest {
    @Test
    fun favorite_button_is_clicked() {
        ActivityScenario.launch(ListActivity::class.java).use {
            scenario -> scenario.onActivity {
                activity -> activity.findViewById<ImageView>(R.id.favorite_heart).performClick()

            val intent =  shadowOf(activity).nextStartedActivity

            assertEquals(
                FavoritePokemonActivity::class.java.name,
                intent.component?.className
            )
            }
        }
    }
}