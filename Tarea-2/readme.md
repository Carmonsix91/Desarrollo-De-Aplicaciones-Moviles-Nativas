# 🐾 Mi Mascota Virtual

¡Bienvenido a Mi Mascota Virtual! Esta es una aplicación de Android desarrollada en **Kotlin** con **Jetpack Compose** que demuestra una arquitectura jerárquica de múltiples actividades, interacciones de UI enriquecidas y animaciones personalizadas. La aplicación te permite cuidar de una adorable mascota virtual llamada Sparky.

## 📜 Descripción

La aplicación está estructurada en tres niveles jerárquicos, cada uno en su propia `Activity`, ofreciendo una experiencia de usuario clara y segmentada:

* **Nivel 1: Habitación Principal (`MainActivity`)**: La pantalla de bienvenida donde puedes ver a Sparky. Al tocarlo, te mostrará su estado de ánimo. Desde aquí, puedes navegar a las áreas de cuidado y juego.
* **Nivel 2: Área de Cuidados (`CareActivity`)**: La cocina de Sparky. Puedes seleccionar diferentes alimentos para ver su información nutricional y, al confirmar, una animación mostrará a Sparky comiendo el alimento seleccionado.
* **Nivel 3: Zona de Juegos (`PlayActivity`)**: Un parque de diversiones para Sparky. Puedes interactuar con diferentes juguetes para aprender sobre sus beneficios. ¡Tocar la pelota inicia un mini-juego interactivo donde Sparky la perseguirá por la pantalla!

## ✨ Características Principales

* **Navegación Jerárquica**: Estructura de 3 `Activities` para una clara separación de contextos.
* **UI Declarativa**: Interfaces de usuario construidas 100% con Jetpack Compose.
* **Puntos de Interés Interactivos**: Elementos en cada pantalla que responden al tacto con información y animaciones.
* **Animaciones Personalizadas**:
    * Transiciones de deslizamiento suaves entre pantallas.
    * Animaciones de "pop", "zoom" y "sacudida" en elementos interactivos.
    * Animaciones de entrada escalonadas para listas.
    * Animaciones complejas como la secuencia de "comer" y el seguimiento en el mini-juego.
* **Mini-Juego Integrado**: Un juego simple pero funcional utilizando `Canvas` y `animateOffsetAsState` en Jetpack Compose.

## 📸 Capturas de Pantalla

| Habitación Principal                                 | Área de Cuidados                                     | Zona de Juegos                                   |
| :--------------------------------------------------- | :--------------------------------------------------- | :----------------------------------------------- |
| __             | __        | __       |
| La pantalla principal con Sparky en el centro.       | La cocina con alimentos interactivos.                | El parque con juguetes y el acceso al mini-juego. |

## 🚀 Instalación y Ejecución

Para ejecutar este proyecto en tu máquina local, sigue estos pasos:

1.  **Clonar el Repositorio**
    ```bash
    git clone [https://github.com/tu-usuario/tu-repositorio.git](https://github.com/tu-usuario/tu-repositorio.git)
    ```
2.  **Abrir en Android Studio**
    * Abre Android Studio (versión Iguana o superior recomendada).
    * Selecciona `File` > `Open` y navega hasta la carpeta del proyecto clonado.
    * Espera a que Gradle sincronice el proyecto y descargue todas las dependencias.

3.  **Ejecutar la Aplicación**
    * Conecta un dispositivo Android o inicia un emulador (API 26+).
    * Selecciona la configuración de `app` y presiona el botón `Run` (▶️).

## 🎨 Diseño y Arquitectura

### Arquitectura
La aplicación sigue un modelo de **múltiples Activities**, donde cada `Activity` sirve como un anfitrión para una pantalla construida enteramente con **Jetpack Compose**. La navegación *entre* `Activities` se gestiona mediante `Intents`, mientras que la lógica de estado y UI *dentro* de cada pantalla es manejada por Composables.

### Diseño Visual
Cada nivel tiene una paleta de colores temática para mejorar la orientación del usuario:
* **Habitación**: Tonos azules, transmitiendo calma.
* **Cocina**: Tonos amarillos, evocando calidez y comida.
* **Parque**: Tonos verdes, representando naturaleza y juego.

### Transiciones y Animaciones
Se implementaron diversas animaciones para crear una experiencia de usuario fluida y atractiva:
* **Entre Activities**: Se usan transiciones de deslizamiento (`overridePendingTransition`) para dar una sensación de desplazamiento lateral en la jerarquía.
* **Interacciones**: Se utilizan APIs de Compose como `animateFloatAsState` para dar retroalimentación instantánea (escala, rotación) al tocar elementos.
* **Animaciones Complejas**: Para secuencias como la del perro comiendo o el mini-juego, se usa `animateOffsetAsState` para movimientos de posición y `LaunchedEffect` para orquestar la secuencia de animaciones (mover, desaparecer, terminar).

## 🧩 Retos y Soluciones

### 1. `ClassCastException` al Dibujar Vectores en `Canvas`
* **Reto**: Al implementar el mini-juego, la aplicación crasheaba con una `ClassCastException: VectorDrawable cannot be cast to BitmapDrawable`. Esto ocurría porque `Canvas.drawImage` esperaba un `ImageBitmap` (píxeles), pero nuestros recursos eran `VectorDrawable` (XML).
* **Solución**: Se corrigió el enfoque de dibujado. En lugar de `ImageBitmap.imageResource`, se utilizó `painterResource` para cargar el recurso como un `Painter` genérico. Dentro del `Canvas`, en lugar de `drawImage`, se usó `translate` para posicionar el cursor y luego `painter.draw()` para renderizar el vector correctamente.

### 2. Orquestar Secuencias de Animación
* **Reto**: La animación del perro comiendo requería una secuencia específica: la comida debía moverse a la boca, encogerse, desaparecer y solo entonces la animación debía terminar.
* **Solución**: Se utilizó un `LaunchedEffect` para controlar la secuencia de forma asíncrona. Se manejó un estado (`animationState`) para definir las fases (inicio, mover, desaparecer). Los `animate*AsState` reaccionaban a los cambios de este estado, y el `LaunchedEffect` se encargaba de cambiar el estado en el momento adecuado usando `delay`s. Esto permitió crear una coreografía de animaciones compleja de manera declarativa.