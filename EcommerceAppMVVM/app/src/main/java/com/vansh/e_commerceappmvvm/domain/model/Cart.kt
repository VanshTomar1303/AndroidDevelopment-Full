package com.vansh.e_commerceappmvvm.domain.model

data class Cart(
    val id: Int,
    val userId: Int,
    val date: String,
    val products: List<CartItem>,
    val __v: Int
)
