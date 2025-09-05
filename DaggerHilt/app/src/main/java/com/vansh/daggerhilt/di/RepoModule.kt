package com.vansh.daggerhilt.di

import com.vansh.daggerhilt.data.repo.MyRepoImpl
import com.vansh.daggerhilt.domain.repo.MyRepo
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
    abstract fun bindMyRepo(
        repoImpl: MyRepoImpl
    ): MyRepo
}