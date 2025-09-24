// CareActivity.kt
package com.cmch.mimascotavirtual

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.cmch.mimascotavirtual.ui.theme.MiMascotaVirtualTheme

class CareActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiMascotaVirtualTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CareScreen(onBack = {
                        finish() // Cierra esta actividad y regresa a la anterior
                    })
                }
            }
        }
    }
}