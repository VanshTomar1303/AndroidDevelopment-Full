package com.vansh.e_commerceappmvvm.data.remote.api

import com.vansh.e_commerceappmvvm.data.remote.dto.CartDto
import com.vansh.e_commerceappmvvm.data.remote.dto.ProductDto
import com.vansh.e_commerceappmvvm.domain.model.Cart
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EcommerceApi {

    @GET("products")
    suspend fun getAllProducts(): List<ProductDto>

    @GET("products/{id}")
    suspend fun getProductById(
        @Path("id") id: Int
    ): ProductDto

    @GET("carts")
    suspend fun getFullCart(): List<CartDto>

    @POST("carts")
    suspend fun addProductToCart(@Body cartDto: CartDto): CartDto
}