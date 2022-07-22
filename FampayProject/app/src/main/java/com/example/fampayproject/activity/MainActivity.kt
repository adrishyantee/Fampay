package com.example.fampayproject.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fampayproject.api.models.Card
import com.example.fampayproject.api.models.CardGroups
import com.example.fampayproject.databinding.ActivityMainBinding
import com.example.fampayproject.interfaces.CardGroupsInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    //This is the URL
    val BASE_URL = "https://run.mocky.io/v3/"


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
    val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(CardGroupsInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<CardGroups>?> {
            override fun onResponse(
                call: Call<List<CardGroups>?>,
                response: Response<List<CardGroups>?>
            ) {
               val responseBody = response.body()!!



                for(cardGroups in responseBody){
                    //do something
                }
            }

            //on failure handle it
            override fun onFailure(call: Call<List<CardGroups>?>, t: Throwable) {
                Log.d("MainActivity","API is Not Fetched" + t.message)
            }
        })




    }

}