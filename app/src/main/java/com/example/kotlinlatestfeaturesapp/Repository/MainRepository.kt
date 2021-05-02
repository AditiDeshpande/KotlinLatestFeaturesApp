package com.example.kotlinlatestfeaturesapp.Repository

import com.example.kotlinlatestfeaturesapp.Model.Post
import com.example.kotlinlatestfeaturesapp.Network.ApiService
import com.example.kotlinlatestfeaturesapp.Network.ApiServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

class MainRepository
@Inject
constructor(private val apiServiceImpl: ApiServiceImpl){
    /*
    Will be using Flow here
    Flow fetches from server multiple data and emits one by one
    If we will do it with suspend function , coroutines it will
    only fetch one by one
     */

    fun getPost(): Flow<List<Post>> = flow {
    /*
    Will give data to ViewModel using emit
     */
        emit(apiServiceImpl.getPost())
    }.flowOn(Dispatchers.IO)
}