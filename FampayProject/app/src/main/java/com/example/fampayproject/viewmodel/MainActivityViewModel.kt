package com.example.fampayproject.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.fampayproject.api.handlers.CardGroupSource
import com.example.fampayproject.utils.ResponseResource
import kotlinx.coroutines.Dispatchers

class MainActivityViewModel(application: Application, private val cardGroupSource: CardGroupSource) : ViewModel(){

    //function to get the list
    fun getCardsList() =
        liveData(Dispatchers.IO) {

        //loading can be done in the beginning
        emit(ResponseResource.loading(data = null))
        try{

            //if successful response
            emit(ResponseResource.success(data = cardGroupSource.getCardGroups()))

        } catch (exception: Exception){

            //if error occurred
            emit(ResponseResource.error(data = null, message = exception.message ?: "Error!"))
        }
    }
}