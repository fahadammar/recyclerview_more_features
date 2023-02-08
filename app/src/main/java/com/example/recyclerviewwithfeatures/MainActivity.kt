package com.example.recyclerviewwithfeatures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewwithfeatures.databinding.ActivityMainBinding
import com.example.recyclerviewwithfeatures.viewmodel.MainViewModel
import com.example.recyclerviewwithfeatures.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding : ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        // creating the instance of the view model
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(applicationContext))[MainViewModel::class.java]

    }
}