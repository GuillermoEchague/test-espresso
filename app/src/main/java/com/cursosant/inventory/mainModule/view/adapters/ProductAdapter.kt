package com.cursosant.inventory.mainModule.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.cursosant.inventory.R
import com.cursosant.inventory.databinding.ItemProductBinding
import com.cursosant.inventory.entities.Product

/****
 * Project: Inventory
 * From: com.cursosant.inventory.mainModule.view.adapters
 * Created by Alain Nicolás Tello on 15/12/21 at 19:41
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
class ProductAdapter(private val listener: OnClickListener) :
    ListAdapter<Product, RecyclerView.ViewHolder>(ProductDiffCallback()){

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val product = getItem(position)

        with(holder as ViewHolder){
            setListener(product)

            binding.tvData.text = context.getString(R.string.item_product_data, product.name, product.quantity)
            binding.tvScore.text = context.getString(R.string.item_product_score, product.score)

            Glide.with(context)
                .load(product.photoUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.imgPhoto)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemProductBinding.bind(view)

        fun setListener(product: Product){
            binding.root.setOnClickListener { listener.onClick(product) }

            binding.root.setOnLongClickListener { listener.onLongClick(product); true }
        }
    }

    class ProductDiffCallback : DiffUtil.ItemCallback<Product>(){
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean = oldItem == newItem
    }
}