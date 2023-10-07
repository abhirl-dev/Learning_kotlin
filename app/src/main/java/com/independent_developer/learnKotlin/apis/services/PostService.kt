package com.independent_developer.learnKotlin.apis.services

import com.independent_developer.learnKotlin.apis.interfaces.Posts
import com.independent_developer.learnKotlin.constants.BASE_URL
import com.independent_developer.learnKotlin.models.PostsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun getAllPosts() {
    val retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Posts::class.java)

    retrofit
        .getPosts()
        .enqueue(object : Callback<List<PostsModel>> {

            override fun onResponse(
                call: Call<List<PostsModel>>,
                response: Response<List<PostsModel>>,
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        for (post in it) {
                            println(post.id)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<PostsModel>>, t: Throwable) {
                println("Error on fetch ==> ${t.localizedMessage}")
            }

        })
}