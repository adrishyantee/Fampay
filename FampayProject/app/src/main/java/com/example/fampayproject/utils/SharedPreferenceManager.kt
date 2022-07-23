package com.example.fampayproject.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.fampayproject.models.Card
import com.example.fampayproject.models.CardGroup
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


//boilerplate code for App Preferences
object SharedPreferenceManager {

    //initialised the constants
    private const val NAME = "sharedPreferences"
    private const val MODE = Context.MODE_PRIVATE

    //using SharedPreferences
    private lateinit var preferences: SharedPreferences
    private lateinit var gsonHelper: Gson
    private val KEY = "Cards"

    //initialise
    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
        print("Created")
    }

    //saveCard
    fun saveCard(cards: ArrayList<Card>){
        val editor = preferences.edit()
        editor.putString("Cards", gsonHelper.toJson(cards))
        editor.apply()
    }

    //getCard
    fun getCard(): ArrayList<Card>{
        val cardsString = preferences.getString("Cards",null)
        val cardsListType : Type = object : TypeToken<ArrayList<CardGroup?>?>(){}.type
        val cardList = gsonHelper.fromJson<Any>(cardsString, cardsListType) as ArrayList<Card>

        if(cardList!=null)
            return cardList;
        else
            return ArrayList()

    }

    //saveCardGroups
    fun saveCardGroup(cardsgroup: ArrayList<CardGroup>){
        val editor = preferences.edit()
        editor.putString("Cards", gsonHelper.toJson(cardsgroup))
        editor.apply()
    }

    //getCardGroups
    fun getCardGroup(): ArrayList<CardGroup>{
        val cardsString = preferences.getString("Cards",null)
        val cardsListType : Type = object : TypeToken<ArrayList<CardGroup?>?>(){}.type
        val cardList = gsonHelper.fromJson<Any>(cardsString, cardsListType) as ArrayList<CardGroup>

        if(cardList!=null)
            return cardList;
        else
            return ArrayList()

    }

}