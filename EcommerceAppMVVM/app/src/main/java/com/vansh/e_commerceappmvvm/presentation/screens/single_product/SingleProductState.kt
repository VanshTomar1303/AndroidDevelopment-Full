package com.vansh.e_commerceappmvvm.presentation.screens.single_product

import com.vansh.e_commerceappmvvm.domain.model.Product
import com.vansh.e_commerceappmvvm.domain.model.Rating

data class SingleProductState(
    val isLoading: Boolean = false,
    val product: Product = Product(
        id = 0,
        title = "",
        description = "",
        price = 0.0,
        category = "",
        image = "",
        rating = Rating(
            rate = 0.0,
            count = 0
        )
    ),
    val error: String? = null
)