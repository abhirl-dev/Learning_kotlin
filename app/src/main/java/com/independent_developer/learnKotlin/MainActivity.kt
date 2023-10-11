package com.independent_developer.learnKotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.independent_developer.learnKotlin.screens.LoginScreen
import com.independent_developer.learnKotlin.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                LoginScreen()
            }
        }
    }
}