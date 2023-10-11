package com.independent_developer.learnKotlin.apis.interfaces

import com.independent_developer.learnKotlin.models.PostsModel
import retrofit2.Call
import retrofit2.http.GET

interface Posts {

    @GET(value = "/posts")
    fun getPosts() : Call<List<PostsModel>>
}