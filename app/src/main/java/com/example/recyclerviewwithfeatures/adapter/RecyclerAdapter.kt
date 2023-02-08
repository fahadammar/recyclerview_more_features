package com.example.recyclerviewwithfeatures.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithfeatures.databinding.ListLayoutBinding
import com.example.recyclerviewwithfeatures.model.NewsModel

class RecyclerAdapter(private val context: Context, private val data: ArrayList<NewsModel>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolderClass>() {
    class ViewHolderClass(binding: ListLayoutBinding, listener : OnItemClickListener) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.titleImage
        val text = binding.showText

        init {
            binding.root.setOnClickListener {
                // here we will place the click listener via the interface
                listener.onItemClick(adapterPosition)
            }
        }
    }

    private lateinit var interfaceInstance : OnItemClickListener
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        interfaceInstance = onItemClickListener
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
}