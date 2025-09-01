package com.vansh.retrofitproject

import com.vansh.retrofitproject.model.PostResponse
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<PostResponse>

}