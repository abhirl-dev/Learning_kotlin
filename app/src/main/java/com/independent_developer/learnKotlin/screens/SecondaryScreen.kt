package com.independent_developer.learnKotlin.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.independent_developer.learnKotlin.components.cards.RecyclerCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondaryScreen() {
    val data: ArrayList<String> = arrayListOf()
    for (i in 1..100) {
        data.add("List view data - $i")
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF00102C)
    ) {
        TopAppBar(title = { Text(text = "App Name") })
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
            ) {
                items(items = data) { name ->
                    RecyclerCard(text = name)
                }
            }
        }
    }
}