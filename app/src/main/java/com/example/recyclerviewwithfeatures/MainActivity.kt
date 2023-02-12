package com.example.recyclerviewwithfeatures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.lifecycle.ViewModelProvider
import androidx.appcompat.widget.SearchView
import com.example.recyclerviewwithfeatures.databinding.ActivityMainBinding
import com.example.recyclerviewwithfeatures.viewmodel.MainViewModel
import com.example.recyclerviewwithfeatures.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        // creating the instance of the view model
        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(applicationContext)
        )[MainViewModel::class.java]

        mainViewModel.setRecycler(mainBinding.recyclerview, this)

        buttonClicks(mainViewModel, mainBinding)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_list, menu)
        val item = menu?.findItem(R.id.search_action)
        val searchView = item?.actionView as SearchView

        mainViewModel.searchViewCallbacks(searchView, mainBinding.recyclerview)

        return super.onCreateOptionsMenu(menu)
    }


    private fun buttonClicks(mainViewModel: MainViewModel, mainBinding: ActivityMainBinding) {
        mainBinding.ascendingButton.setOnClickListener {
            mainViewModel.ascendingSort()
        }
        mainBinding.descendingButton.setOnClickListener {
            mainViewModel.descendingSort()
        }
    }
}