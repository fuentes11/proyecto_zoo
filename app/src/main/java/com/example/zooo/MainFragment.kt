package com.example.zooo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.zooo.databinding.ActivityMainFragmentBinding
import com.example.zooo.trails.*

class MainFragment : AppCompatActivity() {
    private lateinit var binding: ActivityMainFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_activity_main, TrailAsia())
            .commit()
        binding.navView.setOnItemSelectedListener { view ->
            when (view.itemId) {
                R.id.navigation_asia -> {
                    openFragment(TrailAsia())
                }
                R.id.navigation_africa -> {
                    openFragment(TrailAfrica())
                }
                R.id.navigation_antartica -> {
                    openFragment(TrailAntartica())
                }
                R.id.navigation_aqua -> {
                    openFragment(TrailAquarium())
                }
                R.id.navigation_reptile -> {
                    openFragment(TrailReptile())
                }
            }
            true
        }
        onBackPressed()
    }
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_activity_main, fragment)
        transaction.commit()
    }
}