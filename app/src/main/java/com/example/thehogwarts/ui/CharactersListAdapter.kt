package com.example.thehogwarts.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.thehogwarts.databinding.ListViewItemBinding
import com.example.thehogwarts.network.Characters

class CharactersListAdapter(val clickListener: CharactersListener) :
    ListAdapter<Characters, CharactersListAdapter.CharactersViewHolder>(DiffCallback) {

    class CharactersViewHolder(
        var binding: ListViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: CharactersListener, characters: Characters) {
            binding.character = characters
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Characters>() {

        override fun areItemsTheSame(oldItem: Characters, newItem: Characters): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Characters, newItem: Characters): Boolean {
            return oldItem.latin_name == newItem.latin_name && oldItem.animal_type == newItem.animal_type
                    && oldItem.active_time == newItem.active_time
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CharactersViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val characters = getItem(position)
        holder.bind(clickListener, characters)
    }
}

class CharactersListener(val clickListener: (characters: Characters) -> Unit) {
    fun onClick(characters: Characters) = clickListener(characters)
}