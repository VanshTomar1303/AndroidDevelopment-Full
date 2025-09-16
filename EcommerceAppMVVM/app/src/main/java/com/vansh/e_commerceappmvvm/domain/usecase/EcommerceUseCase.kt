package com.vansh.e_commerceappmvvm.domain.usecase

data class EcommerceUseCases(
    val getAllProducts: GetAllProductsUseCase,
    val getProductById: GetProductByIdUseCase,
    val getFullCart: GetFullCartUseCase,
    val addToCartUseCase: AddToCartUseCase
)
