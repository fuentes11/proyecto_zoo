package com.example.zooo

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import androidx.lifecycle.lifecycleScope
import com.example.zooo.databinding.ActivityAddCollectionBinding
import com.example.zooo.data.Zoo
import com.example.zooo.repository.ZooRepository
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddCollection : AppCompatActivity() {
    private lateinit var binding: ActivityAddCollectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCollectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addListener()
        addSpinner()
    }

    private fun addSpinner() {
        val lista = arrayListOf(
            getString(R.string.sendero_1),
            getString(R.string.sendero_2),
            getString(R.string.sendero_3),
            getString(R.string.sendero_4)
        )
        val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, lista)
        binding.spinner.adapter = adapter
    }

    private fun addListener() {
        val repository = ZooRepository.getRepository(this)
        binding.btnAdd.setOnClickListener {
            hideKeyboard()
            with(binding) {
                if (route.text.isBlank()) {
                    Snackbar.make(this.root, "Some fields are empty", Snackbar.LENGTH_SHORT).show()
                } else {
                    lifecycleScope.launch {
                        withContext(Dispatchers.IO) {
                            repository.insert(
                                Zoo(
                                    name = spinner.selectedItem.toString(),
                                    route = route.text.toString()
                                )
                            )
                        }
                        onBackPressed()
                    }
                }
            }
        }
    }

    private fun hideKeyboard() {
        val manager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        manager.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }
}