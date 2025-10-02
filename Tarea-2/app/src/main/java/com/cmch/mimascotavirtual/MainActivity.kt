package com.cmch.mimascotavirtual

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.datastore.preferences.core.edit
import com.cmch.mimascotavirtual.ui.composable.MainScreen
import com.cmch.mimascotavirtual.ui.theme.MiMascotaVirtualTheme
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val coroutineScope = rememberCoroutineScope()
            val preferences = dataStore.data.map { it[IS_DARK_MODE] ?: false }
            val isDarkMode by preferences.collectAsState(initial = false)
            MiMascotaVirtualTheme(darkTheme = isDarkMode) {
                MainScreen(
                    onNavigateToCare = {
                        startActivity(Intent(this, CareActivity::class.java))
                    },
                    onNavigateToPlay = {
                        startActivity(Intent(this, PlayActivity::class.java))
                    },
                    isDarkMode = isDarkMode,
                    onChangeDarkMode = {
                        coroutineScope.launch {
                            dataStore.edit {
                                it[IS_DARK_MODE] = it[IS_DARK_MODE]?.not() ?: false
                            }
                        }
                    }
                )
            }
        }
    }

}
