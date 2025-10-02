// CareActivity.kt
package com.cmch.mimascotavirtual

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.datastore.preferences.core.edit
import com.cmch.mimascotavirtual.ui.composable.CareScreen
import com.cmch.mimascotavirtual.ui.theme.MiMascotaVirtualTheme
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CareActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val coroutineScope = rememberCoroutineScope()
            val preferences = dataStore.data.map { it[IS_DARK_MODE] ?: false }
            val isDarkMode by preferences.collectAsState(initial = false)
            MiMascotaVirtualTheme(darkTheme = isDarkMode) {
                CareScreen(
                    onBack = {
                        finish()
                    },
                    isDarkMode = isDarkMode,
                    onChangeDarkMode = {
                        coroutineScope.launch {
                            dataStore.edit {
                                it[IS_DARK_MODE] = !isDarkMode
                            }
                        }
                    }
                )
            }
        }
    }
}
