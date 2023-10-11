package com.independent_developer.learnKotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.gson.JsonSerializer
import com.independent_developer.learnKotlin.components.CustomButton
import com.independent_developer.learnKotlin.store.DataStore
import com.independent_developer.learnKotlin.ui.theme.AppTheme
import org.json.JSONStringer
import java.util.Objects

class StartScreen : ComponentActivity() {

    private fun nextScreen() {
        val data: MutableMap<String, Any> = mutableMapOf()
        data["Username"] = "abhi"
        data["Password"] = "123456"

        val intend = Intent(this, SecondaryActivity::class.java)
        intend.putExtra("DATA", data.toString())
        startActivity(intend)
    }

    private fun counterScreen() {
        val intend = Intent(this, CounterActivity::class.java)
        startActivity(intend)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(
                darkTheme = true
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(
                        space = 10.dp,
                        alignment = Alignment.CenterVertically
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    CustomButton(
                        onClick = { nextScreen() },
                        text = "Next Screen"
                    )
                    CustomButton(
                        onClick = { counterScreen() },
                        text = "Counter"
                    )
                }
            }
        }
    }
}