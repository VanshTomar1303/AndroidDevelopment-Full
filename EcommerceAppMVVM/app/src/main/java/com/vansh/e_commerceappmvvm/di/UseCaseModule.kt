package com.vansh.e_commerceappmvvm.di

import com.vansh.e_commerceappmvvm.domain.repo.EcommerceRepo
import com.vansh.e_commerceappmvvm.domain.usecase.AddToCartUseCase
import com.vansh.e_commerceappmvvm.domain.usecase.EcommerceUseCases
import com.vansh.e_commerceappmvvm.domain.usecase.GetAllProductsUseCase
import com.vansh.e_commerceappmvvm.domain.usecase.GetFullCartUseCase
import com.vansh.e_commerceappmvvm.domain.usecase.GetProductByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideEcommerceUseCases(
        repo: EcommerceRepo
    ): EcommerceUseCases {
        return EcommerceUseCases(
            getAllProducts = GetAllProductsUseCase(repo),
            getProductById = GetProductByIdUseCase(repo),
            getFullCart = GetFullCartUseCase(repo),
            addToCartUseCase = AddToCartUseCase(repo)
        )
    }
}
