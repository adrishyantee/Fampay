package com.example.fampayproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fampayproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // the functions once the activity is running
        createActivity()
        refreshRecyclerView()

    }


    // update the UI
    // fetch data from API and use it to create the UI
    private fun createActivity(){
        fetchResources()
        errorHandling()
        binding.rlCardGroup.layoutManager = LinearLayoutManager(this)
    }

    // refresh the content in the recycler view
    private fun refreshRecyclerView(){


        binding.refreshLayout.setOnRefreshListener {
            createActivity()
            binding.refreshLayout.isRefreshing = false
        }

    }

    //we handle the error when our resources are not fetched
    private fun errorHandling(){


    }

    private fun fetchResources(){

    }
    
}