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
                val intent: Intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
            }
            // Handle login logic here
        }
    }
}
// ver com android qual eles acham melhor
//when (v?.id) {
//  R.id.loginButton -> {
// Handle login button click
//falta colocar um email+senha adm
