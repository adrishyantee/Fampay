package com.example.fampayproject.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fampayproject.adapters.CardGroupsAdapter
import com.example.fampayproject.api.handlers.CardGroupSource
import com.example.fampayproject.models.CardGroup
import com.example.fampayproject.api.handlers.RetrofitClientInstance
import com.example.fampayproject.databinding.ActivityMainBinding
import com.example.fampayproject.utils.SharedPreferenceManager
import com.example.fampayproject.api.handlers.Status
import com.example.fampayproject.viewmodel.MainActivityViewModelFactory
import com.example.fampayproject.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    //initialise all the variable
    private lateinit var binding: ActivityMainBinding
    private lateinit var cardGroupsAdapter: CardGroupsAdapter
    private lateinit var viewModel: MainActivityViewModel //cardsviewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // the functions once the activity is running
        createActivity()
    }

    //start the activity
    private fun createActivity() {

        //fetch resources from api
        fetchResources()
        //initialise the Recycler View
        initRecyclerView()
        //get the cards handle it and attach to Adapter
        getCardsGroupList()
        //keep on refreshing feature
        refreshRecyclerView()
    }

    //fetch the resources here
    private fun fetchResources() {
        //fetch resources
        val cardGroup = CardGroupSource(RetrofitClientInstance.getClientInstance())

        //create a viewmodelfactory instance
        val viewModelFactory = MainActivityViewModelFactory(application, cardGroup)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)
    }

    //initialise the recyclerview
    private fun initRecyclerView() {
        binding.rlCardGroup.layoutManager = LinearLayoutManager(this)
        cardGroupsAdapter = CardGroupsAdapter(activity = this, arrayListOf())
        binding.rlCardGroup.adapter = cardGroupsAdapter
    }

    // get the response , handle loading and error states and pass the cards list to the adapter
    private fun getCardsGroupList() {


    //using Handlers Class
    val handles = Handlers(binding)
        viewModel.getCardsList()
            .observe(this, Observer {
                it?.let { resource ->
                    when (resource.status) {

                        // when status is successful we pass the cardgroup array list to adapter
                        Status.SUCCESS -> {
                            handles.success()
                            resource.data?.let { it ->
                                    attachToAdapter(it.card_groups as ArrayList<CardGroup>)
                            }
                        }
                        Status.LOADING -> {
                            handles.loading();
                        }
                        Status.ERROR -> {
                            handles.error()
                            Toast.makeText(
                                this,
                                "Error! Connect to Internet",
                                Toast.LENGTH_LONG
                                ).show()
                        }
                    }
                }
            })
    }

    //apply to the adapter
    private fun attachToAdapter(cardgroup: ArrayList<CardGroup>){
        cardGroupsAdapter.apply {
            addCards(cardgroup)
            notifyDataSetChanged()
        }
    }

    // refresh the content in the recycler view when swiped down
    private fun refreshRecyclerView() {
        binding.refreshLayout.setOnRefreshListener {
            //start again
            createActivity()
        }
        binding.refreshLayout.isRefreshing = false
    }
}
