package com.independent_developer.learnKotlin.models

data class PostsModel(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
)