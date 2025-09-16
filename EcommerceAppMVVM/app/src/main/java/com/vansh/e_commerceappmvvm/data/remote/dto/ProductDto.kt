package com.vansh.e_commerceappmvvm.data.remote.dto

data class ProductDto(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val category: String,
    val image: String,
    val rating: RatingDto
)
