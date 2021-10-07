package com.example.zooo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.zooo.databinding.ActivityMainBinding
import com.example.zooo.data.Zoo
import com.example.zooo.repository.ZooRepository
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.math.log
import android.widget.Toast.makeText as toastMakeText

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buildCollection()
        addListeners()
    }
    private fun buildCollection() {
        val repository = ZooRepository.getRepository(this)
        val layoutManager = GridLayoutManager(this, 1)
        lifecycleScope.launch {
            repository.allZoo.collect { Zoo ->
                binding.rvVehicles.apply {
                    adapter = ZooAdapter(Zoo)
                    setLayoutManager(layoutManager)
                }
            }
        }
    }
    private fun addListeners() {
        binding.fbAdd.setOnClickListener {
            startActivity(Intent(this, AddCollection::class.java))
        }
    }
}
