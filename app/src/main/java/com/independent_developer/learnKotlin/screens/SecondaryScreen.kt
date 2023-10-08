package com.independent_developer.learnKotlin.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.independent_developer.learnKotlin.apis.services.getAllPosts
import com.independent_developer.learnKotlin.components.cards.RecyclerCard
import com.independent_developer.learnKotlin.models.PostsModel
import com.independent_developer.learnKotlin.ui.theme.DarkPrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondaryScreen() {
    var listOfPost: List<PostsModel> by remember {
        mutableStateOf<List<PostsModel>>(listOf())
    }

    fun fetchPosts() {
        listOfPost = listOf()
        getAllPosts(
            onSuccess = { data ->
                run {
                    listOfPost = data
                }
            }
        )
    }

    fetchPosts()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF00102C)
    ) {
        TopAppBar(title = { Text(text = "App Name") })
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(10.dp, 20.dp)
            ) {
                ElevatedButton(
                    shape = ShapeDefaults.ExtraSmall,
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = DarkPrimaryColor,
                    ),
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        hoveredElevation = 5.dp,
                        defaultElevation = 10.dp
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                        fetchPosts()
                    }) {
                    Text(text = "Fetch")
                }
            }
            if (listOfPost.isNotEmpty())
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    items(items = listOfPost) { name ->
                        RecyclerCard(text = name.title)
                    }
                }
            else
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally


                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(60.dp),
                        color = Color.White,
                        strokeCap = StrokeCap.Round,
                        trackColor = Color(0x2CFFFFFF)
                    )
                }
        }
    }
}