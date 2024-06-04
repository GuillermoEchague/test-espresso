package com.cursosant.inventory.mainModule.model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.cursosant.inventory.common.InventoryPreferences
import com.cursosant.inventory.common.MyDataBase
import com.cursosant.inventory.entities.Product


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