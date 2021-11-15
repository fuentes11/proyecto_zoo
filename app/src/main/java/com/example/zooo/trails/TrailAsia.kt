package com.example.zooo.trails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.zooo.R
import com.example.zooo.databinding.ActivityTrailAsiaBinding

class TrailAsia : Fragment() {
    private lateinit var binding: ActivityTrailAsiaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityTrailAsiaBinding.inflate(inflater, container, false)
        return binding.root
    }
}
