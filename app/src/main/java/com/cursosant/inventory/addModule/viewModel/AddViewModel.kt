package com.cursosant.inventory.addModule.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cursosant.inventory.addModule.model.AddRepository
import com.cursosant.inventory.entities.Product

/****
 * Project: Inventory
 * From: com.cursosant.inventory.addModule.viewModel
 * Created by Alain Nicolás Tello on 15/12/21 at 19:30
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
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