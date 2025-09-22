package com.example.kotlinapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SelectionScreen(onButtonClick: () -> Unit) {
    var checkboxState by remember { mutableStateOf(false) }
    var radioOption by remember { mutableStateOf("Opción 1") }
    var switchState by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "Elementos de Selección",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Checkbox
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkboxState,
                onCheckedChange = { checkboxState = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Checkbox - Selección múltiple")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // RadioButtons
        Text("RadioButtons - Selección única:")
        Column {
            RadioOption(
                text = "Opción 1",
                selected = radioOption == "Opción 1",
                onSelect = { radioOption = "Opción 1" }
            )
            RadioOption(
                text = "Opción 2",
                selected = radioOption == "Opción 2",
                onSelect = { radioOption = "Opción 2" }
            )
            RadioOption(
                text = "Opción 3",
                selected = radioOption == "Opción 3",
                onSelect = { radioOption = "Opción 3" }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Switch
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                checked = switchState,
                onCheckedChange = { switchState = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Switch - Activado/Desactivado")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Explicación
        Text(
            "Los elementos de selección permiten al usuario elegir entre diferentes opciones. " +
                    "Checkbox para selecciones múltiples, RadioButton para una única selección, " +
                    "y Switch para alternar entre dos estados.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Estado actual
        Text("Estado actual:")
        Text("Checkbox: ${if (checkboxState) "Seleccionado" else "No seleccionado"}")
        Text("Opción seleccionada: $radioOption")
        Text("Switch: ${if (switchState) "Activado" else "Desactivado"}")
        Button(onButtonClick) { Text("Second Activity") }
    }
}

@Composable
fun RadioOption(text: String, selected: Boolean, onSelect: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        RadioButton(
            selected = selected,
            onClick = onSelect
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}