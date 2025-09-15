# KOTLIN
## 🌟 Características Comunes

*   **Navegación Intuitiva:** Un menú principal (usando BottomNavigationBar o similar) permite al usuario cambiar fácilmente entre las diferentes secciones/fragments.
*   **Contenido Educativo por Sección:** Cada sección (Fragment en Android Nativo, Pantalla/Widget en Flutter) está diseñada para:
    *   Mostrar un **título descriptivo** del elemento de UI que se está explicando.
    *   Proveer **ejemplos visuales** claros del elemento en funcionamiento.
    *   Incluir una **explicación breve y concisa** (2-3 líneas) sobre el propósito y uso del elemento.
    *   Ofrecer una **demostración interactiva** que permita al usuario probar y experimentar con el elemento directamente.
*   **Diseño Limpio y Organizado:** Se ha priorizado una interfaz de usuario clara y fácil de entender.

---

## 📱 Versión Android Nativo (Kotlin)

Esta versión utiliza la arquitectura recomendada por Android con Activities y Fragments.

### 🏗️ Estructura de la App (Kotlin)

*   **`MainActivity.kt`**:
    *   Actúa como el contenedor principal de la aplicación.
    *   Aloja el sistema de navegación (probablemente un `BottomNavigationView` o `TabLayout` junto con un `ViewPager2` o `FragmentContainerView` gestionado por el Navigation Component).
    *   Gestiona la transición y muestra de los diferentes Fragments.

*   **Fragments:**
    1.  **`TextFieldsFragment.kt` (`fragment_text_fields.xml`)**
        *   **Título:** TextFields / Campos de Texto (EditText)
        *   **Explicación:** Permiten a los usuarios ingresar y editar texto y números.
        *   **Demostración:** Incluye varios `EditText` (para texto simple, números, contraseñas) y muestra el texto ingresado en tiempo real.
    2.  **`ButtonsFragment.kt` (`fragment_buttons.xml`)**
        *   **Título:** Botones (Button, ImageButton)
        *   **Explicación:** Permiten a los usuarios iniciar acciones o navegar.
        *   **Demostración:** Muestra diferentes tipos de botones (`Button`, `OutlinedButton`, `TextButton`, `ImageButton`, `FloatingActionButton`) que realizan acciones simples (ej. incrementar un contador, mostrar un Toast).
    3.  **`SelectionFragment.kt` (`fragment_selection.xml`)**
        *   **Título:** Elementos de Selección (CheckBox, RadioButton, Switch)
        *   **Explicación:** Permiten a los usuarios elegir entre varias opciones o activar/desactivar configuraciones.
        *   **Demostración:**
            *   `CheckBox`: Múltiples checkboxes para selección múltiple.
            *   `RadioGroup` con `RadioButton`: Para selección única entre opciones.
            *   `Switch`: Para activar/desactivar una opción.
            *   Se muestra el estado actual de las selecciones.
    4.  **`ListsFragment.kt` (`fragment_lists.xml`)**
        *   **Título:** Listas (RecyclerView)
        *   **Explicación:** Muestran colecciones de datos de manera eficiente y desplazable.
        *   **Demostración:** Un `RecyclerView` que muestra una lista de ítems. Permite interactuar con los ítems (ej. clic para mostrar un mensaje, botón para eliminar un ítem).
    5.  **`InfoElementsFragment.kt` (`fragment_info_elements.xml`)**
        *   **Título:** Elementos de Información (TextView, ImageView, ProgressBar)
        *   **Explicación:** Muestran información estática o dinámica al usuario.
        *   **Demostración:**
            *   `TextView`: Ejemplos de texto con diferentes estilos.
            *   `ImageView`: Muestra una imagen.
            *   `ProgressBar`: Muestra un indicador de progreso (circular y horizontal).
            *   (Opcional) Interacción para cambiar el progreso o la imagen.

### 🛠️ Requisitos Técnicos (Kotlin)

*   Utilización del **Navigation Component** de Jetpack para gestionar la navegación entre fragments de manera robusta y eficiente.
*   Uso de **View Binding** o **Data Binding** para interactuar con las vistas de forma segura.
*   Implementación de `RecyclerView.Adapter` y `ViewHolder` para el `ListsFragment`.
*   Manejo adecuado del ciclo de vida de los Fragments y la Activity.
*   (Opcional, pero recomendado) Uso de **ViewModels** para separar la lógica de UI de los datos, especialmente si hay interacciones complejas o se necesita persistir el estado.

## 🚀 Cómo Ejecutar

### Android Nativo (Kotlin)

1.  Clona el repositorio (o la carpeta del proyecto Kotlin).
2.  Abre el proyecto en Android Studio.
3.  Asegúrate de tener un emulador configurado o un dispositivo físico conectado.
4.  Sincroniza el proyecto con los archivos Gradle.
5.  Ejecuta la configuración de la aplicación 'app'.
---

## 💡 Funcionalidad que Conecte Diferentes Fragments/Pantallas (Ejemplo)

Para cumplir con el requisito de "Funcionalidad que conecte diferentes fragments", se podría implementar:

*   **En Android Nativo:** Desde el `ButtonsFragment`, un botón podría navegar al `InfoElementsFragment` pasando un argumento (ej. un string) que se muestre en un `TextView` de ese fragmento. Esto se puede lograr con el Navigation Component y Safe Args.

