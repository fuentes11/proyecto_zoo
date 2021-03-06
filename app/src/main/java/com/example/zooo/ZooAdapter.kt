package com.example.zooo

import android.app.ListActivity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.zooo.databinding.CollectionZooBinding
import com.example.zooo.data.Zoo
import com.example.zooo.repository.ZooRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.Double as Double

@Suppress("MemberVisibilityCanBePrivate")
class ZooAdapter(private val list: List<Zoo>) :
        RecyclerView.Adapter<ZooAdapter.ZooViewHolder>() {
    class ZooViewHolder(val binding: CollectionZooBinding) :
            RecyclerView.ViewHolder(binding.root)

    lateinit var view: View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZooViewHolder {
        val binding =
                CollectionZooBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ZooViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ZooViewHolder, position: Int) {
        val repository = ZooRepository.getRepository(holder.binding.root.context)
        val context = holder.binding.root.context
        holder.binding.btnDelete.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                repository.deleteById(list[position].id)
            }
        }

        with(holder.binding) {
            trail.text = list[position].name
            route.text = list[position].route
        }
    }

    override fun getItemCount(): Int = list.size
}
