package com.thays.pokedex.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.autofill.AutofillManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.thays.pokedex.ListActivity
import com.thays.pokedex.R
import com.thays.pokedex.databinding.ActivityMainBinding

class LoginActivity: AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var loginRepository: LoginRepository
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loginRepository = LoginRepository(this)
        loginViewModel = LoginViewModel(loginRepository)

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
            val isLoggedIn = loginViewModel.login(email, password)

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