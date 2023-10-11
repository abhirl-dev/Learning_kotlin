package com.independent_developer.learnKotlin.store

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.independent_developer.learnKotlin.models.PostsModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

@Composable
fun DataStore() {

    var posts: List<PostsModel> by remember {
        mutableStateOf<List<PostsModel>>(listOf())
    }

}