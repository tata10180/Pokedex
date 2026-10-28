package com.thays.pokedex.presentation.login.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.thays.pokedex.R
import com.thays.pokedex.data.repository.LoginRepositoryImpl
import com.thays.pokedex.databinding.ActivityMainBinding
import com.thays.pokedex.di.PokemonApplication
import com.thays.pokedex.presentation.list.view.ListActivity
import com.thays.pokedex.domain.repository.LoginRepository
import com.thays.pokedex.presentation.login.viewmodel.LoginViewModel
import com.thays.pokedex.presentation.login.viewmodel.LoginViewModelFactory

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var loginRepository: LoginRepository


    private val viewModel: LoginViewModel by viewModels{
        val container = (application as PokemonApplication).container
        LoginViewModelFactory(container.loginRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val container = (application as PokemonApplication).container
        loginRepository = container.loginRepository


        binding.emailField.setText("admin@gmail.com")
        binding.passwordField.setText("admin123")

        binding.loginButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v?.id == R.id.loginButton) {
            val email = binding.emailField.text.toString() //activity
            val password = binding.passwordField.text.toString()//activity

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT)
                    .show()
                return
            }
            val isLoggedIn = viewModel.login(email, password)

            if (isLoggedIn) {
                val intent = Intent(this, ListActivity::class.java)//activity
                startActivity(intent)//activity
                finish()
            } else {
                binding.emailField.setText("")//activity
                binding.passwordField.setText("")//activity

                Toast.makeText(this, "Email or Password Invalid!", Toast.LENGTH_SHORT)
                    .show()//activity?
            }
        }
    }
}