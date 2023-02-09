package com.example.recyclerviewwithfeatures.viewmodel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithfeatures.NewsActivity
import com.example.recyclerviewwithfeatures.adapter.RecyclerAdapter
import com.example.recyclerviewwithfeatures.model.NewsRepository

class MainViewModel(val context: Context) : ViewModel() {
    val TAG = "mainViewModelTAG"

    private val adapter = RecyclerAdapter(
        context,
        NewsRepository.getNews()
    )

    fun setRecycler(recyclerView: RecyclerView, activity: Activity) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : RecyclerAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                Log.d(TAG, "onItemClick: Item Clicked at position $position")
                // Now from here we will be taking the user to the NewsActivity
                val intent = Intent(activity, NewsActivity::class.java)
                intent.putExtra("heading", NewsRepository.getHeading(position))
                intent.putExtra("imageID", NewsRepository.getNewsImage(position))
                intent.putExtra(
                    "news",
                    activity.resources.getString(NewsRepository.getNewsString(position))
                )
                activity.startActivity(intent)
            }
        })
    }
}