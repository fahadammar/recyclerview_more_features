package com.example.recyclerviewwithfeatures.viewmodel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithfeatures.NewsActivity
import com.example.recyclerviewwithfeatures.SwipeGestures
import com.example.recyclerviewwithfeatures.adapter.RecyclerAdapter
import com.example.recyclerviewwithfeatures.model.NewsModel
import com.example.recyclerviewwithfeatures.model.NewsRepository
import java.util.*
import kotlin.collections.ArrayList

class MainViewModel(val context: Context) : ViewModel() {
    val TAG = "mainViewModelTAG"
    private lateinit var tempArrayList: ArrayList<NewsModel>
    val newsArrayList = NewsRepository.getNews()

    private val adapter = returnAdapter()

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

        swipeGestures(recyclerView)
    }

    private fun swipeGestures(recyclerView: RecyclerView) {
        val swipeGestures = object : SwipeGestures(context) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                Log.d(TAG, "onMove: BEFORE --> $newsArrayList")
                val from_pos = viewHolder.adapterPosition
                val to_pos = target.adapterPosition
                Collections.swap(newsArrayList, from_pos, to_pos)
                adapter.notifyItemMoved(from_pos, to_pos)
                Log.d(TAG, "onMove: AFTER --> $newsArrayList")
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                when (direction) {
                    ItemTouchHelper.RIGHT -> {
                        val archiveItem = newsArrayList[viewHolder.adapterPosition]
                        adapter.deleteItem(viewHolder.adapterPosition)
                        adapter.addItem(newsArrayList.size, archiveItem)
                    }
                    ItemTouchHelper.LEFT -> {
                        adapter.deleteItem(viewHolder.adapterPosition)
                    }
                }
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeGestures)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    fun searchViewCallbacks(searchView: SearchView, recyclerView: RecyclerView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                tempArrayList.clear()
                val searchText = newText!!.lowercase(Locale.getDefault())
                if (searchText.isNotEmpty()) {
                    newsArrayList.forEach {
                        if (it.news.lowercase(Locale.getDefault()).contains(searchText)) {
                            tempArrayList!!.add(it)
                        }
                    }
                    adapter.notifyDataSetChanged()
                } else {
                    tempArrayList.clear()
                    tempArrayList.addAll(newsArrayList)
                    adapter.notifyDataSetChanged()
                }
                return false
            }
        })
    }

    private fun returnAdapter(): RecyclerAdapter {
        tempArrayList = ArrayList()
        tempArrayList.addAll(newsArrayList)
        return RecyclerAdapter(
            context,
            tempArrayList
        )
    }
}
