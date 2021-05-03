package com.example.kotlinlatestfeaturesapp.DI

import com.example.kotlinlatestfeaturesapp.Network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
SingletonComponent means available throughout the app
previously we used to write ApplicationComponent
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesUrl() = "https://jsonplaceholder.typicode.com/"

    /*
    This ApiService is the class which I myself I have written
     */
    @Provides
    @Singleton
    fun providesApiService(url:String) : ApiService =
            Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)


}