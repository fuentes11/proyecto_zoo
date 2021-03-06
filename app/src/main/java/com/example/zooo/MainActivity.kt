package com.example.zooo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zooo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addListeners()
    }
    private fun addListeners() {
        binding.btn2.setOnClickListener {
            startActivity(Intent(this, CollectionMain::class.java))
        }
        binding.btn1.setOnClickListener {
            startActivity(Intent(this, TrailsActivity::class.java))
        }
        binding.btn3.setOnClickListener {
            startActivity(Intent(this, Prices::class.java))
        }
        binding.btn4.setOnClickListener {
            startActivity(Intent(this, RulesActivity::class.java))
        }
    }
}