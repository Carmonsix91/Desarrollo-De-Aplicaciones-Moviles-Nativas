package com.example.kotlinapp.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun SelectionScreen() {
    var checked by remember { mutableStateOf(false) }
    var radioOption by remember { mutableStateOf("Opción 1") }
    var switchState by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Elementos de Selección", style = MaterialTheme.typography.headlineMedium)

        // Checkbox
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = checked, onCheckedChange = { checked = it })
            Text("Checkbox")
        }

        // RadioButton Group
        Text("Opciones de RadioButton:", modifier = Modifier.padding(top = 8.dp))
        RadioButtonGroup(
            options = listOf("Opción 1", "Opción 2", "Opción 3"),
            selectedOption = radioOption,
            onOptionSelected = { radioOption = it }
        )

        // Switch
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = switchState, onCheckedChange = { switchState = it })
            Text("Switch")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Checkbox: selección múltiple. RadioButton: selección única. Switch: alternar estados on/off.")
    }
}

@Composable
fun RadioButtonGroup(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Column {
        options.forEach { option ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = option == selectedOption,
                    onClick = { onOptionSelected(option) }
                )
                Text(text = option, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}