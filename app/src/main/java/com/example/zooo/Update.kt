package com.example.zooo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.lifecycleScope
import com.example.zooo.dao.ZooDao
import com.example.zooo.data.Zoo
import com.example.zooo.databinding.ActivityUpdateBinding
import com.example.zooo.repository.ZooRepository
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Update : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addListener()
        addSpinner()
    }

    private fun addSpinner() {
        val lista = arrayListOf(
                getString(R.string.sendero_1),
                getString(R.string.sendero_2),
                getString(R.string.sendero_3),
                getString(R.string.sendero_5),
                getString(R.string.sendero_4)

        )
        val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, lista)
        binding.spinner.adapter = adapter
    }

    private fun addListener() {
        val repository = ZooRepository.getRepository(this)
        val intent = Intent(this, CollectionMain::class.java)

        binding.Update.setOnClickListener {

            with(binding) {
                if (nameu.text.isBlank()) {
                    Snackbar.make(this.root, "Some fields are empty", Snackbar.LENGTH_SHORT).show()
                } else {
                    lifecycleScope.launch {
                        withContext(Dispatchers.IO) {
                            repository.update(
                                    name = spinner.selectedItem.toString(),
                                    route = nameu.toString(),
                                    id = taskId
                            )
                        }
                        onBackPressed()
                    }
                }
            }
        }
    }
}