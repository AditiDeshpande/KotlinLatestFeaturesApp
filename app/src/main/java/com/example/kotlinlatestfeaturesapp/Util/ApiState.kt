package com.example.kotlinlatestfeaturesapp.Util

import com.example.kotlinlatestfeaturesapp.Model.Post

sealed class ApiState{
    /*
     Manages all the states like success , failure etc in data
     fetching from the server
     */
    /*
    Created object which is calling class ApiState
     */
    object Loading : ApiState()
    class Failure(val msg:Throwable) : ApiState()
    class Success(val data:List<Post>) : ApiState()
    object Empty : ApiState()
}
