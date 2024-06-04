package com.cursosant.inventory.mainModule.model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.cursosant.inventory.common.InventoryPreferences
import com.cursosant.inventory.common.MyDataBase
import com.cursosant.inventory.entities.Product

/****
 * Project: Inventory
 * From: com.cursosant.inventory.mainModule.model
 * Created by Alain Nicolás Tello on 15/12/21 at 19:36
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
class MainRepository(application: Application) {
    private val myDataBase by lazy { MyDataBase.getInstance() }
    private val preferences = InventoryPreferences.getInstance(application)

    val products: LiveData<MutableList<Product>> = liveData {
        val productsLiveData = myDataBase.getProductsLiveData()
        emitSource(productsLiveData)
    }

    fun deleteProduct(product: Product, callback: (isSuccess: Boolean) -> Unit){
        callback (myDataBase.delete(product))
    }

    fun setWelcome(value: Boolean){
        preferences.setWelcome(value)
    }

    fun getWelcome(): Boolean = preferences.getWelcome()
}