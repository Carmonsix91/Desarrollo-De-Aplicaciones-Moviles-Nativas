package com.cmch.mimascotavirtual.ui

import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cmch.mimascotavirtual.R

@Composable
fun BallChaseMinigame(onDismiss: () -> Unit) {
    // ✨ CORRECCIÓN: Cargar los recursos como Painters, no como ImageBitmaps.
    // Painter es capaz de manejar tanto vectores como mapas de bits.
    val dogPainter = painterResource(id = R.drawable.ic_dog)
    val ballPainter = painterResource(id = R.drawable.ic_ball)

    // Definimos el tamaño que queremos para nuestras imágenes en Dp
    val imageSizeDp = 100.dp
    // Convertimos el tamaño a píxeles para el cálculo de centrado y el dibujado
    val imageSizePx = with(LocalDensity.current) { imageSizeDp.toPx() }

    // El estado y la animación de las posiciones no cambian.
    val ballPosition = remember { mutableStateOf(Offset(400f, 400f)) }
    val dogPosition by animateOffsetAsState(
        targetValue = ballPosition.value,
        animationSpec = tween(durationMillis = 1000),
        label = "dogPositionAnimation"
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures { offset ->
                        // La lógica para mover la pelota no cambia.
                        ballPosition.value = Offset(
                            offset.x - imageSizePx / 2,
                            offset.y - imageSizePx / 2
                        )
                    }
                }
        ) {
            // Dibuja el fondo del "parque"
            drawRect(Color(0xFF66BB6A))

            // ✨ CORRECCIÓN: Usamos `translate` y `painter.draw()` en lugar de `drawImage()`.
            // Esto permite al Painter dibujarse a sí mismo en la posición correcta.

            // Dibuja la pelota
            translate(left = ballPosition.value.x, top = ballPosition.value.y) {
                with(ballPainter) {
                    draw(size = Size(imageSizePx, imageSizePx))
                }
            }

            // Dibuja al perro
            translate(left = dogPosition.x, top = dogPosition.y) {
                with(dogPainter) {
                    draw(size = Size(imageSizePx, imageSizePx))
                }
            }
        }

        // El botón de cierre no cambia.
        IconButton(
            onClick = onDismiss,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            Icon(Icons.Default.Close, contentDescription = "Cerrar Juego", tint = Color.White)
        }
    }
}