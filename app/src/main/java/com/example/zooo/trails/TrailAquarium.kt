package com.example.zooo.trails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.zooo.MainFragment
import com.example.zooo.R
import com.example.zooo.databinding.ActivityTrailAquariumBinding

class TrailAquarium : Fragment() {
    private lateinit var binding: ActivityTrailAquariumBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = ActivityTrailAquariumBinding.inflate(inflater, container, false)
        return binding.root

    }





}