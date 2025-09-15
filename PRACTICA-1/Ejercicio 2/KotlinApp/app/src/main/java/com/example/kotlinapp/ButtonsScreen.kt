package com.example.kotlinapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonsScreen() {
    var count by remember { mutableStateOf(0) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Botones", style = MaterialTheme.typography.headlineMedium)

        Button(onClick = { count++ }) {
            Text("Contador: $count")
        }

        Spacer(modifier = Modifier.height(8.dp))
        IconButton(onClick = { count-- }) {
            Icon(Icons.Filled.Favorite, contentDescription = "Decrementar")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Los botones permiten realizar acciones. Button es estándar e IconButton permite usar iconos como acciones.")
    }
}