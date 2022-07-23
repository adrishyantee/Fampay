package com.example.fampayproject.activity

import android.view.View
import com.example.fampayproject.databinding.ActivityMainBinding

class Handlers(val binding: ActivityMainBinding) {

    //when response is loading
    fun loading(){
        binding.rlCardGroup.visibility = View.GONE
        binding.retryButton.visibility = View.GONE
    }

    //when response is successful
    fun success(){
        binding.rlCardGroup.visibility = View.VISIBLE
        binding.retryButton.visibility = View.GONE
        binding.progressBar.visibility = View.GONE
    }

    //when response is not obtained
    fun error(){
        binding.rlCardGroup.visibility = View.VISIBLE
        binding.retryButton.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
    }
}