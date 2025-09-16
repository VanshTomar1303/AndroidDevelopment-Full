package com.vansh.e_commerceappmvvm.domain.repo

import com.vansh.e_commerceappmvvm.domain.model.Cart
import com.vansh.e_commerceappmvvm.domain.model.Product

interface EcommerceRepo {
    suspend fun getAllProduct(): List<Product>

    suspend fun getProductById(id: Int): Product

    suspend fun getAllCart(): List<Cart>

    suspend fun addProductToCart(cart: Cart): Cart
}