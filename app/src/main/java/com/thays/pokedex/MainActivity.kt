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

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private val ADMIN_EMAIL = "admin@gmail.com"
    private val ADMIN_PASSWORD = "admin123"
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
        binding.loginButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.loginButton) {
            val email = binding.emailField.text.toString()
            val password = binding.passwordField.text.toString()
            if(email.isNotEmpty() && password.isNotEmpty()) {
               if(email == ADMIN_EMAIL && password == ADMIN_PASSWORD) {
                   val intent: Intent = Intent(this, HomeActivity::class.java)
                   startActivity(intent)
               }else{
                   binding.emailField.setText("")
                   binding.passwordField.setText("")
                   Toast.makeText(this, "Email or Password Invalid!", Toast.LENGTH_SHORT).show()
               }
            }else{
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
            }
            // Handle login logic here
        }
    }
    }

