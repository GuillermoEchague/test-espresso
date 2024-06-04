package com.cursosant.inventory.mainModule.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cursosant.inventory.entities.Product
import com.cursosant.inventory.mainModule.model.MainRepository


class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MainRepository(application)

    private val products = repository.products

    fun getProducts(): LiveData<MutableList<Product>> = products

    fun deleteProduct(product: Product){
        repository.deleteProduct(product){
            Log.i("Action", "send producto to delete...")
        }
    }

    fun setWelcome(value: Boolean){
        repository.setWelcome(value)
    }

    private val welcome: MutableLiveData<Boolean> = MutableLiveData()

    init {
        getWelcome()
    }

    fun isWelcome(): MutableLiveData<Boolean> = welcome

    private fun getWelcome(){
        welcome.value = repository.getWelcome()
    }
}