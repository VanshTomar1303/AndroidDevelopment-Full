package com.vansh.e_commerceappmvvm.domain.usecase

import com.vansh.e_commerceappmvvm.domain.model.Product
import com.vansh.e_commerceappmvvm.domain.repo.EcommerceRepo
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(
    private val repo: EcommerceRepo
) {
    suspend operator fun invoke(): List<Product>{
        return repo.getAllProduct()
    }
}