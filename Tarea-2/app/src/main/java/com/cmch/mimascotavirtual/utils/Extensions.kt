package com.cmch.mimascotavirtual.utils

import android.app.Activity
import com.cmch.mimascotavirtual.R

// Función de extensión para la actividad que aplica una animación de entrada
fun Activity.slideInRight() {
    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
}

// Función de extensión para la actividad que aplica una animación de salida
fun Activity.slideOutLeft() {
    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
}

// Hacemos lo mismo para la dirección opuesta
fun Activity.slideInLeft() {
    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
}

fun Activity.slideOutRight() {
    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
}