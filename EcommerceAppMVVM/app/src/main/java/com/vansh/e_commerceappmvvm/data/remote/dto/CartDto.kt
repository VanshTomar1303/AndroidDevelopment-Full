package com.vansh.e_commerceappmvvm.data.remote.dto

data class CartDto(
    val id: Int,
    val userId: Int,
    val date: String,
    val products: List<CartItemDto>,
    val __v: Int
)
