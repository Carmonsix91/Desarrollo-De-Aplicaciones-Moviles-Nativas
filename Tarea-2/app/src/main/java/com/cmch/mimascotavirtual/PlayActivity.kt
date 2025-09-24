package com.cmch.mimascotavirtual

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.cmch.mimascotavirtual.PlayScreen
import com.cmch.mimascotavirtual.ui.theme.MiMascotaVirtualTheme
//import com.cmch.mimascotavirtual.utils.slideOutRight

class PlayActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiMascotaVirtualTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Llama a la pantalla de Compose y le pasa la función para volver.
                    PlayScreen(onBack = {
                        finish() // Cierra esta actividad para regresar a MainActivity.
                    })
                }
            }
        }
    }

    // Sobreescribimos el método finish() para aplicar nuestra transición personalizada.
    override fun finish() {
        super.finish()
        // Aplica la animación de deslizamiento hacia la derecha al salir.
        slideOutRight()
    }

    // Hacemos lo mismo para el botón de "atrás" del sistema operativo.
    @SuppressLint("GestureBackNavigation")
    @Deprecated("Deprecated in Java", ReplaceWith("super.onBackPressed()"))
    override fun onBackPressed() {
        super.onBackPressed()
        slideOutRight()
    }
}