package com.vansh.e_commerceappmvvm.presentation.screens.product_list

import com.vansh.e_commerceappmvvm.domain.model.Product

data class ProductListState(
    val isLoading: Boolean = false,
    val productList: List<Product> = emptyList(),
    val error: String? = null
)