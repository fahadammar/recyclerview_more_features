package com.example.recyclerviewwithfeatures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.recyclerviewwithfeatures.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {
    private val TAG = NewsActivity::class.java.toString()
    lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras

        setView(binding, bundle)

    }

    private fun setView(binding: ActivityNewsBinding, bundle: Bundle?) {
        binding.titleText.text = bundle!!.getString("heading")
        binding.newsImage.setImageResource(bundle.getInt("imageID"))
        binding.news.text = bundle.getString("news")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}