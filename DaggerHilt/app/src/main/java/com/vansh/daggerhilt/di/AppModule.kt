package com.vansh.daggerhilt.di

import com.vansh.daggerhilt.data.remote.MyApi
import com.vansh.daggerhilt.data.repo.MyRepoImpl
import com.vansh.daggerhilt.domain.repo.MyRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMyApi(): MyApi{
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }

//    @Provides
//    @Singleton
//    fun provideMyRepo(api: MyApi, @Named("hello1") hello: String): MyRepo{
//        return MyRepoImpl(api)
//    }

    @Provides
    @Singleton
    @Named("hello1")
    fun provideString1() = "HEllo 1"

    @Provides
    @Singleton
    @Named("hello2")
    fun provideString2() = "HEllo 2"
}