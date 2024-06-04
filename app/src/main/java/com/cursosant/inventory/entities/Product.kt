package com.cursosant.inventory.entities

/****
 * Project: Inventory
 * From: com.cursosant.inventory
 * Created by Alain Nicolás Tello on 15/12/21 at 19:23
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
data class Product(var id: Long = 0,
                   var name: String,
                   var quantity: Int,
                   var photoUrl: String = "",
                   var score: Double = 0.0,
                   var totalVotes: Long = 0)
