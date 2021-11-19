package com.example.zooo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zooo.databinding.ActivityMainBinding
import com.example.zooo.databinding.ActivityTrailsBinding
import com.example.zooo.trails.TrailAfrica
import com.example.zooo.trails.TrailAntartica
import com.example.zooo.trails.TrailAquarium
import com.example.zooo.trails.TrailAsia

class TrailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTrailsBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addListeners()
    }

    private fun addListeners() {
        binding.btn01.setOnClickListener {
            startActivity(Intent(this, MainFragment::class.java))
        }
        binding.fbHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }


}