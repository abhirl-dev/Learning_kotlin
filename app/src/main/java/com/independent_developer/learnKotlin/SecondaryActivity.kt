package com.independent_developer.learnKotlin


import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Popup
import com.google.android.material.snackbar.Snackbar
import com.independent_developer.learnKotlin.screens.SecondaryScreen
import com.independent_developer.learnKotlin.ui.theme.AppTheme
import org.w3c.dom.Text

class SecondaryActivity : ComponentActivity() {

    private fun getString() {
        println("arguments ----------------------------------> " + intent.extras!!.getString("DATA"))
        Toast
            .makeText(this, intent.extras!!.getString("DATA"), Toast.LENGTH_SHORT)
            .show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getString()
        setContent {
            AppTheme {
                SecondaryScreen()
            }
        }
    }
}