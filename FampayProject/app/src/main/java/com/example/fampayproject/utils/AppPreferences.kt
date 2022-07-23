package com.example.fampayproject.utils

import android.content.Context
import android.content.SharedPreferences


//boilerplate code for App Preferences
object AppPreferences {

    //initialised the constants
    private const val NAME = "sharedPref"
    private const val MODE = Context.MODE_PRIVATE

    //using SharedPreferences
    private lateinit var preferences: SharedPreferences
    private val KEY = "KEY"

    //initialise
    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
        print("Created")
    }

    //editing
    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    //removing cards
    var removedCardsJson: String?
        get() = preferences.getString(KEY, "")
        set(value) = preferences.edit {
            it.putString(KEY, value)
        }
}