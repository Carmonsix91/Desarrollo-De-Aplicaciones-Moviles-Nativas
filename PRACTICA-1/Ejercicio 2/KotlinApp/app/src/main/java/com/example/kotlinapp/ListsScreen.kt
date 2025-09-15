package com.example.kotlinapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListsScreen() {
    val items = remember { List(50) { "Elemento ${it + 1}" } }

    Column(modifier = Modifier.fillMaxSize()) {
        Text("Listas", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(16.dp))

        LazyColumn {
            items(items) { item ->
                Text(item, modifier = Modifier.padding(16.dp))
            }
        }

        Text("LazyColumn muestra listas eficientemente renderizando solo los elementos visibles.",
            modifier = Modifier.padding(16.dp))
    }
}