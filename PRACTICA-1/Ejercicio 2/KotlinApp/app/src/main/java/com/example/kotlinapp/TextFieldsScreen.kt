package com.example.kotlinapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun TextFieldsScreen() {
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("TextFields", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Escribe algo") }
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text("Los TextFields permiten al usuario ingresar y editar texto. Son esenciales para formularios y entradas de datos.")

        Spacer(modifier = Modifier.height(8.dp))
        Text("Texto ingresado: $text")
    }
}