package com.example.kscrafts05.Module

import com.example.kscrafts05.Retrofit.Api
import com.example.kscrafts05.Utilties.Constant.APIURL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl(APIURL).addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Singleton
    @Provides
    fun provideProductApi(retrofit: Retrofit): Api{
        return  retrofit.create(Api::class.java)
    }
}