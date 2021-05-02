package com.example.kotlinlatestfeaturesapp.Network

import com.example.kotlinlatestfeaturesapp.Model.Post
import retrofit2.http.GET

/*
For Retrofit
To fetch body from foll. website
https://jsonplaceholder.typicode.com/posts
 */

interface ApiService {
    /*Get is the Retrofit annotation for get request for the
    server
    https://jsonplaceholder.typicode.com/posts
    posts is from above http link which we have put in get
    request
    */
    @GET("posts")
    suspend fun getPost(): List<Post>{
        /*
        List<Post> return type it is list of Post Model class
        which we have created before
         */
        /*
        Making the function suspend to run it on background thread
        kotlin coroutines
         */

    }
}