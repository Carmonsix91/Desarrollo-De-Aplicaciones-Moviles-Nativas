package com.cmch.mimascotavirtual.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Creamos una extensión para acceder fácilmente al DataStore
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class ThemeDataStore(context: Context) {

    private val dataStore = context.dataStore

    // Definimos la clave para guardar si el modo oscuro está activado
    companion object {
        val IS_DARK_MODE_KEY = booleanPreferencesKey("is_dark_mode")
    }

    // Flujo para obtener el estado actual del tema.
    // Si no hay nada guardado, por defecto será 'false' (tema claro).
    val themeFlow: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[IS_DARK_MODE_KEY] ?: false
    }

    // Función para guardar la preferencia del tema
    suspend fun saveTheme(isDarkMode: Boolean) {
        dataStore.edit { settings ->
            settings[IS_DARK_MODE_KEY] = isDarkMode
        }
    }
}