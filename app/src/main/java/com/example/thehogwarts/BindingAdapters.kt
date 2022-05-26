package com.example.thehogwarts

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.thehogwarts.network.Characters
import com.example.thehogwarts.ui.CharactersApiStatus
import com.example.thehogwarts.ui.CharactersListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Characters>?) {
    val adapter = recyclerView.adapter as CharactersListAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: CharactersApiStatus?) {
    when(status) {
        CharactersApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        CharactersApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        CharactersApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}