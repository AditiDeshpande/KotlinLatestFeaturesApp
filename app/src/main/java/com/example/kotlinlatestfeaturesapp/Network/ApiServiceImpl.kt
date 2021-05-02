package com.example.kotlinlatestfeaturesapp.Network

import com.example.kotlinlatestfeaturesapp.Model.Post
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService){
    suspend fun getPost():List<Post> = apiService.getPost()
}