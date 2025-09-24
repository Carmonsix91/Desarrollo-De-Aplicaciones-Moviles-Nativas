package com.cmch.mimascotavirtual


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

// Data class para modelar la comida
data class FoodItem(val name: String, val description: String, val imageRes: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CareScreen(onBack: () -> Unit) {
    // --- ESTADOS ---
    val foodItems = listOf(
        FoodItem("Manzana", "Rica en vitaminas y fibra. ¡Un snack saludable!", R.drawable.ic_apple),
        FoodItem("Pescado", "Alto en Omega-3 para un pelaje brillante.", R.drawable.ic_fish),
        FoodItem("Carne", "Gran fuente de proteína para tener más energía.", R.drawable.ic_meat)
    )

    var selectedFood by remember { mutableStateOf<FoodItem?>(null) }
    var pressedFoodItem by remember { mutableStateOf<FoodItem?>(null) }
    var eatingFoodItem by remember { mutableStateOf<FoodItem?>(null) }

    // --- ANIMACIONES ---
    val scale = animateFloatAsState(
        targetValue = if (pressedFoodItem != null) 1.15f else 1.0f,
        animationSpec = tween(durationMillis = 100),
        finishedListener = { pressedFoodItem = null },
        label = "foodPop"
    )

    // --- ESTRUCTURA PRINCIPAL ---
    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Cocina de Sparky", fontWeight = FontWeight.Bold) },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Regresar"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFFFBC02D),
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    )
                )
            },
            containerColor = Color.Transparent
        ) { innerPadding ->
            // --- CONTENIDO PRINCIPAL DE LA PANTALLA ---
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Toca un alimento para ver su información", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(40.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    itemsIndexed(foodItems) { index, food ->
                        val visible = remember { mutableStateOf(false) }
                        LaunchedEffect(Unit) {
                            delay(100L * index)
                            visible.value = true
                        }
                        AnimatedVisibility(
                            visible = visible.value,
                            enter = fadeIn(animationSpec = tween(300)) +
                                    slideInVertically(initialOffsetY = { it / 2 }, animationSpec = tween(300))
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .scale(if (pressedFoodItem == food) scale.value else 1.0f)
                                    .clickable {
                                        pressedFoodItem = food
                                        selectedFood = food
                                    }
                            ) {
                                Image(
                                    painter = painterResource(id = food.imageRes),
                                    contentDescription = food.name,
                                    modifier = Modifier.size(100.dp)
                                )
                                Text(food.name, fontWeight = FontWeight.SemiBold)
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = onBack) { Text("Regresar a la Habitación") }
            }
        }

        // --- DIÁLOGO DE INFORMACIÓN ---
        selectedFood?.let { food ->
            AlertDialog(
                onDismissRequest = { selectedFood = null },
                title = { Text(food.name) },
                text = { Text(food.description) },
                confirmButton = {
                    Button(onClick = {
                        eatingFoodItem = food
                        selectedFood = null
                    }) {
                        Text("Dar de comer")
                    }
                }
            )
        }

        // --- CAPA DE ANIMACIÓN DE "COMER" ---
        if (eatingFoodItem != null) {
            EatingAnimationOverlay(
                foodItem = eatingFoodItem!!,
                onAnimationFinished = {
                    eatingFoodItem = null
                }
            )
        }
    }
}

/**
 * Un Composable privado que muestra la capa con la animación del perro comiendo.
 */
@Composable
private fun EatingAnimationOverlay(foodItem: FoodItem, onAnimationFinished: () -> Unit) {
    var animationState by remember { mutableStateOf(0) } // 0: inicio, 1: mover, 2: desaparecer
    var petMouthPosition by remember { mutableStateOf(Offset.Zero) }
    var screenSize by remember { mutableStateOf(IntSize.Zero) }

    val foodOffset by animateOffsetAsState(
        targetValue = if (animationState >= 1) petMouthPosition else Offset(screenSize.width / 2f, screenSize.height / 2f),
        animationSpec = tween(durationMillis = 800),
        label = "foodOffset",
        finishedListener = {
            if (animationState == 1) animationState = 2
        }
    )

    val foodAlpha by animateFloatAsState(targetValue = if (animationState == 2) 0f else 1f, tween(300), label = "foodAlpha")
    val foodScale by animateFloatAsState(targetValue = if (animationState == 2) 0.5f else 1f, tween(300), label = "foodScale")

    LaunchedEffect(Unit) {
        delay(100)
        animationState = 1
        delay(1500)
        onAnimationFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f))
            .onGloballyPositioned { screenSize = it.size },
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_dog2),
                contentDescription = "Mascota",
                modifier = Modifier
                    .size(200.dp)
                    .onGloballyPositioned {
                        val localPos = it.localToRoot(Offset.Zero)
                        petMouthPosition = Offset(localPos.x + it.size.width / 2, localPos.y + it.size.height / 3)
                    }
            )
        }

        Image(
            painter = painterResource(id = foodItem.imageRes),
            contentDescription = foodItem.name,
            modifier = Modifier
                .offset(
                    x = (foodOffset.x / LocalDensity.current.density).dp,
                    y = (foodOffset.y / LocalDensity.current.density).dp
                )
                .offset((-50).dp, (-50).dp)
                .size(100.dp)
                .scale(foodScale)
                .alpha(foodAlpha)
        )
    }
}