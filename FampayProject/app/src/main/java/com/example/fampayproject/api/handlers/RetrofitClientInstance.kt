package com.example.fampayproject.api.handlers

import com.example.fampayproject.api.interfaces.CardGroupsInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClientInstance {

    //URL to be fetched
    private const val BASE_URL = "https://run.mocky.io"

    fun getClientInstance(): CardGroupsInterface {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(CardGroupsInterface::class.java)
    }
}