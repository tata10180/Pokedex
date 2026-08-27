package com.thays.pokedex

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.thays.pokedex.databinding.ActivityMainBinding
import android.view.View
import android.content.Intent
import android.widget.Toast
import android.content.Context
import androidx.core.content.edit

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private val ADMIN_EMAIL = "admin@gmail.com" //viewmodel
    private val ADMIN_PASSWORD = "admin123" //viewmodel

    override fun onCreate(savedInstanceState: Bundle?) { //activity daqui
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.loginButton.setOnClickListener(this) //ate aqui?
    }


    override fun onClick(v: View?) {
        if (v?.id == R.id.loginButton) { //viewmodel?
            val email = binding.emailField.text.toString() //activity
            val password = binding.passwordField.text.toString()//activity
            if (email.isNotEmpty() && password.isNotEmpty()) {//viewmodel?
                if (email == ADMIN_EMAIL && password == ADMIN_PASSWORD) {//repository
                    val shared = getSharedPreferences("PokedexApp", Context.MODE_PRIVATE).edit{//repository
                        putString("EMAIL", ADMIN_EMAIL)//repository
                        putBoolean("isLoggedIn", true)//repository
                        apply()//repository
                    }
                    val intent: Intent = Intent(this, ListActivity::class.java)//activity
                    startActivity(intent)//activity
                } else {
                    binding.emailField.setText("")//activity
                    binding.passwordField.setText("")//activity
                    Toast.makeText(this, "Email or Password Invalid!", Toast.LENGTH_SHORT).show()//activity?
                }
            } else {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT)//activity?
                    .show()
            }//ate aqui?
            // Handle login logic here
        }
    }

}

