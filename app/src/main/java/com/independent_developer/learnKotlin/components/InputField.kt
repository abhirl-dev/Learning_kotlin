package com.independent_developer.learnKotlin.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun InputField(
    inputType: InputType,
    keyboardAction: KeyboardActions,
    focusRequester: FocusRequester? = null,
) {
    var value: String by remember { mutableStateOf("") }

    TextField(
        singleLine = true,
        modifier = Modifier
            .padding(2.dp)
            .clip(shape = ShapeDefaults.ExtraSmall)
            .fillMaxWidth()
            .focusRequester(focusRequester = focusRequester ?: FocusRequester()),
        shape = ShapeDefaults.ExtraSmall,
        visualTransformation = inputType.visualTransformation,
        keyboardOptions = inputType.keyboardOptions,
        keyboardActions = keyboardAction,
        label = {
            Text(
                text = inputType.name,
                modifier = Modifier.background(color = Color.Transparent)
            )
        },
        leadingIcon = { Icon(imageVector = inputType.icon, contentDescription = null) },
        value = value,
        onValueChange = { value = it },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.DarkGray,
            focusedContainerColor = Color.White,
        )
    )
}

sealed class InputType(
    var name: String,
    var icon: ImageVector,
    var keyboardOptions: KeyboardOptions,
    var visualTransformation: VisualTransformation,
) {
    object Name : InputType(
        name = "Username",
        icon = Icons.Default.Person,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        ),
        visualTransformation = VisualTransformation.None,
    )

    object Password : InputType(
        name = "Password",
        icon = Icons.Default.Lock,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = PasswordVisualTransformation(),
    )
}