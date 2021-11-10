package com.example.zooo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zooo.databinding.ActivityPricesBinding

class Prices : AppCompatActivity() {
    private lateinit var binding: ActivityPricesBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPricesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addListeners()
    }

    private fun addListeners() {
        binding.fbHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}