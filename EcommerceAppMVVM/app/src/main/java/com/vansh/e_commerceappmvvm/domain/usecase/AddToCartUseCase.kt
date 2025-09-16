package com.vansh.e_commerceappmvvm.domain.usecase

import com.vansh.e_commerceappmvvm.domain.model.Cart
import com.vansh.e_commerceappmvvm.domain.repo.EcommerceRepo
import javax.inject.Inject

class AddToCartUseCase @Inject constructor(
    private val repo: EcommerceRepo
) {
    suspend operator fun invoke(cart: Cart): Cart{
        return repo.addProductToCart(cart)
    }
}