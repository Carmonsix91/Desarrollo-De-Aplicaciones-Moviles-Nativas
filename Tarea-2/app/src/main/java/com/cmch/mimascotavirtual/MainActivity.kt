package com.cmch.mimascotavirtual

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.cmch.mimascotavirtual.ui.theme.MiMascotaVirtualTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiMascotaVirtualTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        onNavigateToCare = {
                            // Navegar a la pantalla de cuidados
                            startActivity(Intent(this, CareActivity::class.java))
                            //slideInRight() // Aplicar transición de entrada
                        },
                        onNavigateToPlay = {
                            startActivity(Intent(this, PlayActivity::class.java))
                        }
                    )
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        // Aplicar transición de salida cuando esta actividad se pausa
        //slideOutLeft()
    }
}