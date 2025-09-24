package com.cmch.mimascotavirtual


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.cmch.mimascotavirtual.ui.BallChaseMinigame
import kotlinx.coroutines.delay

data class ToyItem(val name: String, val description: String, val imageRes: Int)

// ✨ Se requiere esta anotación para TopAppBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayScreen(onBack: () -> Unit) {
    val toyItems = listOf(
        ToyItem(
            "Pelota",
            "Perfecta para correr y mejorar la agilidad. ¡El juego de buscar nunca falla!",
            R.drawable.ic_ball
        ),
        ToyItem(
            "Frisbee",
            "Ideal para jugar al aire libre y mejorar los reflejos de Sparky.",
            R.drawable.ic_car
        ),
        ToyItem(
            "Hueso de Goma",
            "Ayuda a mantener los dientes fuertes y limpios mientras se divierte.",
            R.drawable.ic_bone
        )
    )
    var selectedToy by remember { mutableStateOf<ToyItem?>(null) }
    var animatingToyIndex by remember { mutableStateOf<Int?>(null) }
    var showBallGame by remember { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(
        targetValue = if (animatingToyIndex != null) 5f else 0f,
        animationSpec = repeatable(
            iterations = 4, // Se repetirá 4 veces (2 sacudidas completas)
            animation = tween(durationMillis = 80, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    // ✨ CAMBIO: Usamos Scaffold como el contenedor principal
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Parque de Juegos", fontWeight = FontWeight.Bold) },
                // ✨ NUEVO: Ícono para regresar
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF388E3C), // Verde oscuro
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            // ✨ CAMBIO: Aplicamos el padding y el fondo
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color(0xFFA5D6A7))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // El resto del contenido, incluidas las animaciones, permanece igual
            Text(
                text = "Toca un juguete para saber sus beneficios",
                fontSize = 16.sp,
                color = Color.DarkGray.copy(alpha = 0.8f),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(40.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                itemsIndexed(toyItems) { index, toy ->
                    // ✨ NUEVO: Estado y efecto para la animación de entrada escalonada
                    val visible = remember { mutableStateOf(false) }
                    LaunchedEffect(Unit) {
                        delay(100L * index) // Retraso basado en el índice
                        visible.value = true
                    }
                    AnimatedVisibility(
                        visible = visible.value,
                        enter = fadeIn(animationSpec = tween(durationMillis = 500)) +
                                slideInVertically(
                                    initialOffsetY = { it / 2 },
                                    animationSpec = tween(durationMillis = 500)
                                )
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                // ✨ CAMBIO: Aplicamos la rotación de la animación de "sacudida"
                                .rotate(if (animatingToyIndex == index) rotationAngle else 0f)
                                .clickable {
                                    animatingToyIndex = index // Inicia la animación de sacudida
                                    if (index == 0) {
                                        showBallGame = true
                                    } else {
                                        selectedToy = toy
                                    }
                                    // Retrasamos la aparición del diálogo para que la animación se vea
                                    // El tiempo total de la animación es 80ms * 4 = 320ms
                                    // Usamos un ligero margen extra.
                                    // Esto se puede hacer más robusto con un `LaunchedEffect`
                                    // pero para este ejemplo, un delay simple funciona.
                                    //selectedToy = toy
                                }
                        ) {
                            Image(
                                painter = painterResource(id = toy.imageRes),
                                contentDescription = toy.name,
                                modifier = Modifier.size(110.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(toy.name, fontWeight = FontWeight.SemiBold, color = Color.DarkGray)
                        }
                    }
                }
            }
        }

        selectedToy?.let { toy ->
            AlertDialog(
                onDismissRequest = { selectedToy = null },
                title = { Text(toy.name) },
                text = { Text(toy.description) },
                confirmButton = {
                    Button(onClick = { selectedToy = null }) {
                        Text("¡A Jugar!")
                    }
                }
            )
        }

        if (showBallGame) {
            Dialog(
                onDismissRequest = { showBallGame = false },
                // Estas propiedades hacen que el diálogo ocupe toda la pantalla
                properties = DialogProperties(usePlatformDefaultWidth = false)
            ) {
                BallChaseMinigame(
                    onDismiss = { showBallGame = false }
                )
            }
        }
    }
}
