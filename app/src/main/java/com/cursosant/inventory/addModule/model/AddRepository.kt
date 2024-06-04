package com.cursosant.inventory.addModule.model

import com.cursosant.inventory.common.MyDataBase
import com.cursosant.inventory.entities.Product


class AddRepository {
    private val myDataBase by lazy { MyDataBase.getInstance() }

    fun addProduct(product: Product, callback: (isSuccess: Boolean) -> Unit){
        callback(myDataBase.add(product))
    }
}