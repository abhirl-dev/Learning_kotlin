package com.independent_developer.learnKotlin.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.independent_developer.learnKotlin.components.CustomButton

@Composable
fun CounterScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF00102C)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(
                20.dp,
                alignment = Alignment.Top
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CustomButton(onClick = { /*TODO*/ }, text = "Decrement")
            Text(text = "")
            CustomButton(onClick = { /*TODO*/ }, text = "Increment")

        }
    }
}