package com.example.fampayproject.api.interfaces

import com.example.fampayproject.models.CardGroups
import retrofit2.http.GET

interface CardGroupsInterface {

    //get request
    @GET("v3/04a04703-5557-4c84-a127-8c55335bb3b4")
    //we are obtained as a CardGroups instance
    suspend fun getCardGroups(): CardGroups
}