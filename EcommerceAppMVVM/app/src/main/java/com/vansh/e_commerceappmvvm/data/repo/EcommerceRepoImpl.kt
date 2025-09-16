package com.vansh.e_commerceappmvvm.data.repo

import com.vansh.e_commerceappmvvm.data.mapper.ProductMapper
import com.vansh.e_commerceappmvvm.data.remote.api.EcommerceApi
import com.vansh.e_commerceappmvvm.domain.model.Cart
import com.vansh.e_commerceappmvvm.domain.model.Product
import com.vansh.e_commerceappmvvm.domain.repo.EcommerceRepo
import javax.inject.Inject

class EcommerceRepoImpl @Inject constructor(
    private val api: EcommerceApi
): EcommerceRepo {
    override suspend fun getAllProduct(): List<Product> {
        return api
            .getAllProducts()
            .map {
                productDto -> ProductMapper.dtoToProduct(productDto)
            }.toList()
    }

    override suspend fun getProductById(id: Int): Product {
        return ProductMapper.dtoToProduct(api.getProductById(id))
    }

    override suspend fun getAllCart(): List<Cart> {
        return api.getFullCart().map {
            cart ->
            ProductMapper.cartDtoToCart(cart)
        }.toList()
    }

    override suspend fun addProductToCart(cart: Cart): Cart {
        val cartList = ProductMapper.cartToCartDto(cart)
        return ProductMapper.cartDtoToCart(api.addProductToCart(cartList))
    }

}