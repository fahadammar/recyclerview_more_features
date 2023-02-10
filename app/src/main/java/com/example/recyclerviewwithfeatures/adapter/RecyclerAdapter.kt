package com.example.recyclerviewwithfeatures.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithfeatures.databinding.ListLayoutBinding
import com.example.recyclerviewwithfeatures.model.NewsModel

class RecyclerAdapter(private val context: Context, private val data: ArrayList<NewsModel>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolderClass>() {
    class ViewHolderClass(binding: ListLayoutBinding, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(binding.root) {
        val image = binding.titleImage
        val text = binding.showText

        init {
            binding.root.setOnClickListener {
                // here we will place the click listener via the interface
                listener.onItemClick(adapterPosition)
            }
        }
    }

    private lateinit var interfaceInstance: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        interfaceInstance = onItemClickListener
    }

    fun deleteItem(index: Int) {
        Log.d(TAG, "deleteItem: The FIRST-Index is --> ${data.size}")
        data.removeAt(index)
        Log.d(TAG, "deleteItem: The Index is --> ${data.size}")
        notifyDataSetChanged()
    }

    fun addItem(index: Int, news: NewsModel) {
        Log.d(TAG, "addItem: The Index is --> $index")
        data.add(index,news)
        notifyDataSetChanged()
        /**
         * Using this above add with the index, we add at the last, because the size counts starts from 1
         * so if on another way, if we simply use the add(), it will the element at the last index of the array
         * */
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val binding = ListLayoutBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return ViewHolderClass(binding, this.interfaceInstance)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val newsModelInstance = data[position]
        holder.image.setImageResource(newsModelInstance.image)
        holder.text.text = newsModelInstance.news
    }

    override fun getItemCount(): Int {
        return data.size
    }

    val TAG = "RecyclerAdapter"
}