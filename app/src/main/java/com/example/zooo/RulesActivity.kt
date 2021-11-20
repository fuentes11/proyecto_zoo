package com.example.zooo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zooo.databinding.ActivityPricesBinding
import com.example.zooo.databinding.ActivityRulesBinding

class RulesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRulesBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRulesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addListeners()
    }
    private fun addListeners() {
        binding.fbHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}