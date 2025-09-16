package com.vansh.e_commerceappmvvm.presentation.screens.cart

import com.vansh.e_commerceappmvvm.domain.model.Cart
import com.vansh.e_commerceappmvvm.domain.model.Product

data class CartState(
    val isLoading: Boolean = false,
    val cartList: List<Cart> = emptyList(),
    val productList: List<Product> = emptyList(),
    val totalAmount: Double = 0.00,
    val error: String? = ""
)
