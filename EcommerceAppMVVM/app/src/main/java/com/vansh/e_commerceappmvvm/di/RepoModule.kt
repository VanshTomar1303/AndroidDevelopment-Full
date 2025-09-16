package com.vansh.e_commerceappmvvm.di

import com.vansh.e_commerceappmvvm.data.repo.EcommerceRepoImpl
import com.vansh.e_commerceappmvvm.domain.repo.EcommerceRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    @Singleton
    abstract fun bindEcommerceRepo(
        impl: EcommerceRepoImpl
    ): EcommerceRepo
}