package com.cmch.mimascotavirtual.viewmodel

import com.cmch.mimascotavirtual.preferences.ThemeDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ThemeViewModel(private val themeDataStore: ThemeDataStore) : ViewModel() {

    // Exponemos el flujo del tema como un StateFlow para que la UI lo observe
    val isDarkMode: SharedFlow<Boolean> = themeDataStore.themeFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false // Valor inicial por defecto
    )

    // Función para que la UI solicite un cambio de tema
    fun setTheme(isDarkMode: Boolean) {
        viewModelScope.launch {
            themeDataStore.saveTheme(isDarkMode)
        }
    }
}
