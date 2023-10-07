package com.independent_developer.learnKotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.independent_developer.learnKotlin.screens.SecondaryScreen
import com.independent_developer.learnKotlin.ui.theme.AppTheme

class SecondaryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                SecondaryScreen()
            }
        }
    }
}