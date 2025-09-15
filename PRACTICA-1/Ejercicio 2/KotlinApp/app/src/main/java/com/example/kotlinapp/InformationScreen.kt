package com.example.kotlinapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun InformationScreen() {
    var progress by remember { mutableStateOf(0.5f) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Elementos de Información", style = MaterialTheme.typography.headlineMedium)

        Text("Este es un TextView estático")

        LinearProgressIndicator(progress = {progress})

        Slider(value = progress, onValueChange = { progress = it })
        Image(modifier = Modifier.size(128.dp), painter = painterResource(R.drawable.ic_pri), contentDescription = null)
        Spacer(modifier = Modifier.height(16.dp))
        Text("TextView: muestra texto. ImageView: muestra imágenes. ProgressBar: indica progreso.")
    }
}