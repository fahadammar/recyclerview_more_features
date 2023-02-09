package com.example.recyclerviewwithfeatures.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithfeatures.adapter.RecyclerAdapter
import com.example.recyclerviewwithfeatures.model.NewsRepository

class MainViewModel(val context: Context) : ViewModel() {
    private val adapter = RecyclerAdapter(
        context,
        NewsRepository.getNews()
    )

    fun setRecycler(recyclerView: RecyclerView) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : RecyclerAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(context, "Item Clicked at position $position", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}