package com.cursosant.inventory.addModule.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cursosant.inventory.addModule.model.AddRepository
import com.cursosant.inventory.entities.Product


class AddViewModel : ViewModel() {
    private val repository = AddRepository()

    private val inProgress = MutableLiveData<Boolean>()
    private val result = MutableLiveData<Boolean>()

    fun isInProgress(): MutableLiveData<Boolean> = inProgress

    fun getResult(): MutableLiveData<Boolean> = result

    fun addProduct(product: Product){
        inProgress.value = true
        repository.addProduct(product){
            inProgress.value = false
            result.value = it
        }
    }
}