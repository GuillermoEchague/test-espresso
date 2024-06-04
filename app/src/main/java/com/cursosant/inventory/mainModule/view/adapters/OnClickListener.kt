package com.cursosant.inventory.mainModule.view.adapters

import com.cursosant.inventory.entities.Product


interface OnClickListener {
    fun onClick(product: Product)
    fun onLongClick(product: Product)
}