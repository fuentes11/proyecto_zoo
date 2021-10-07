package com.example.zooo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    RecyclerView.Adapter<ZooAdapter.VehiclesViewHolder>() {
    class VehiclesViewHolder(val binding: CollectionZooBinding) :
        RecyclerView.ViewHolder(binding.root)
        lateinit var view: View
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiclesViewHolder {
        val binding = CollectionZooBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VehiclesViewHolder(binding)
    }
    override fun onBindViewHolder(holder: VehiclesViewHolder, position: Int, ) {
        val repository = ZooRepository.getRepository(holder.binding.root.context)

        holder.binding.btnDelete.setOnClickListener{
            GlobalScope.launch(Dispatchers.IO){
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
