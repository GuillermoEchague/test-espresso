package com.cursosant.inventory.common

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

/****
 * Project: Inventory
 * From: com.cursosant.inventory.common
 * Created by Alain Nicolás Tello on 15/12/21 at 19:24
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
class InventoryPreferences(application: Application) {
    private val preferences: SharedPreferences

    companion object{
        private const val K_WELCOME = "is_welcome"

        private var INSTANCE: InventoryPreferences? = null

        fun getInstance(application: Application) = INSTANCE ?: synchronized(this){
            InventoryPreferences(application).also { INSTANCE = it }
        }
    }

    init {
        preferences = PreferenceManager.getDefaultSharedPreferences(application)
    }

    fun setWelcome(value: Boolean){
        preferences.edit().putBoolean(K_WELCOME, value).apply()
    }

    fun getWelcome(): Boolean = preferences.getBoolean(K_WELCOME, true)
}