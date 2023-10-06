package com.independent_developer.demo.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.independent_developer.demo.ui.theme.DarkPrimaryColor

@Composable
fun CustomButton(onClick: () -> Unit, text: String = "Button") {
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        shape = ShapeDefaults.ExtraSmall,
        colors = ButtonDefaults.buttonColors(
            containerColor = DarkPrimaryColor,
        ),
        onClick = { onClick() }) {
        Text(
            fontSize = 16.sp,
            text = text,
        )
    }
}