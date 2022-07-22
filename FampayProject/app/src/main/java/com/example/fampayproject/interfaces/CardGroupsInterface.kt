package com.example.fampayproject.interfaces

import com.example.fampayproject.api.models.CardGroups
import retrofit2.Call
import retrofit2.http.GET

interface CardGroupsInterface {
    // to get request

    @GET("04a04703-5557-4c84-a127-8c55335bb3b4")
    fun getData(): Call<List<CardGroups>>
}