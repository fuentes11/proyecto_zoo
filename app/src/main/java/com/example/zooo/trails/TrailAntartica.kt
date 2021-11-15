package com.example.zooo.trails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.zooo.CollectionMain
import com.example.zooo.R
import com.example.zooo.databinding.ActivityTrailAntarticaBinding

class TrailAntartica : Fragment() {
    private lateinit var binding: ActivityTrailAntarticaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityTrailAntarticaBinding.inflate(inflater, container, false)
        return binding.root
    }

    }

