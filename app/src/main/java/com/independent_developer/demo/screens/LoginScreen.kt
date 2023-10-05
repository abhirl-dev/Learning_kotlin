package com.independent_developer.demo.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.independent_developer.demo.components.CustomButton
import com.independent_developer.demo.components.InputField
import com.independent_developer.demo.components.InputType

fun showToast(context: Context) {
    val toast = Toast.makeText(context, "Login button is pressed", Toast.LENGTH_SHORT)
    toast.show()
}

@Composable
fun LoginScreen() {
    val passwordFocusRequester = FocusRequester()
    val focusManager: FocusManager = LocalFocusManager.current
    val context: Context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF00102C)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(
                10.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            InputField(
                inputType = InputType.Name,
                keyboardAction = KeyboardActions(
                    onNext = {
                        passwordFocusRequester.requestFocus()
                    }
                ),
            )
            InputField(
                inputType = InputType.Password,
                keyboardAction = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }
                ),
                focusRequester = passwordFocusRequester,
            )

            CustomButton(
                onClick = {
                    showToast(context)
                },
                text = "LOGIN"
            )
        }
    }
}