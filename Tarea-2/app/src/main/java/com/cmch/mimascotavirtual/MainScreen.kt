package com.cmch.mimascotavirtual


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cmch.mimascotavirtual.R

// ✨ Se requiere esta anotación para CenterAlignedTopAppBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(onNavigateToCare: () -> Unit, onNavigateToPlay: () -> Unit) {
    var showMoodDialog by remember { mutableStateOf(false) }
    var isPetPressed by remember { mutableStateOf(false) }
    val scale = animateFloatAsState(targetValue = if (isPetPressed) 1.2f else 1.0f, label = "petScale")

    // ✨ CAMBIO: Usamos Scaffold como el contenedor principal de la pantalla
    Scaffold(
        topBar = {
            // ✨ NUEVO: Definimos la barra de aplicación superior
            CenterAlignedTopAppBar(
                title = { Text("La Habitación de Sparky", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF0288D1), // Un azul un poco más oscuro para la barra
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding -> // Scaffold nos provee un padding para que el contenido no quede debajo de la TopAppBar
        Box(
            // ✨ CAMBIO: Aplicamos el padding y mantenemos el fondo
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color(0xFF81D4FA)) // Fondo azul cielo
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // El resto del contenido de la columna permanece igual...
                Image(
                    painter = painterResource(id = R.drawable.ic_pet),
                    contentDescription = "Mi Mascota Virtual",
                    modifier = Modifier
                        .size(200.dp)
                        .scale(scale.value)
                        .clip(CircleShape)
                        .clickable {
                            showMoodDialog = true
                            isPetPressed = !isPetPressed
                        }
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text("¡Tócame!", fontSize = 18.sp, color = Color.White.copy(alpha = 0.8f))
                Spacer(modifier = Modifier.height(60.dp))
                Row {
                    Button(onClick = onNavigateToCare) { Text("Ir a Cuidados") }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = onNavigateToPlay) { Text("Ir a Juegos") }
                }
            }

            if (showMoodDialog) {
                AlertDialog(
                    onDismissRequest = {
                        showMoodDialog = false
                        isPetPressed = false
                    },
                    title = { Text("Estado de Ánimo") },
                    text = { Text("Sparky se siente feliz y con energía. ¡Gracias por cuidarme!") },
                    confirmButton = {
                        Button(onClick = {
                            showMoodDialog = false
                            isPetPressed = false
                        }) { Text("¡Genial!") }
                    }
                )
            }
        }
    }
}