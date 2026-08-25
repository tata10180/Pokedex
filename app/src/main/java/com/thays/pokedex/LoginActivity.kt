package com.thays.pokedex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.thays.pokedex.databinding.ActivityMainBinding

class LoginActivity: AppCompatActivity(), /*View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var loginRepository: LoginRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginRepository = LoginRepository(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.loginButton.setOnClickListener(this)
    }

    -> precisa jogar o codigo do mainActivity aqui
}*/