# FLUTTER

## 🐦 Ejercicio 2: Transiciones entre Activities y Fragment

Esta versión utiliza la filosofía de "todo es un Widget" de Flutter para construir la interfaz de usuario.

### 🏗️ Estructura de la App (Flutter)

*   **`main.dart`**:
    *   Punto de entrada de la aplicación Flutter.
    *   Configura el `MaterialApp` o `CupertinoApp`.
    *   Define la pantalla principal (`HomeScreen` o similar) que contendrá la navegación.

*   **Pantallas/Widgets Principales (equivalentes a los Fragments):**
    Cada "Fragment" de la versión nativa se traduce en una pantalla o un conjunto de Widgets complejos en Flutter.
    1.  **`text_fields_screen.dart`**
        *   **Título:** TextFields / Campos de Texto (TextField)
        *   **Explicación:** Permiten a los usuarios ingresar y editar texto y números.
        *   **Demostración:** Varios `TextField` widgets (para texto, números, contraseñas) con `TextEditingController` para gestionar la entrada y mostrarla.
    2.  **`buttons_screen.dart`**
        *   **Título:** Botones (ElevatedButton, TextButton, IconButton, etc.)
        *   **Explicación:** Permiten a los usuarios iniciar acciones o navegar.
        *   **Demostración:** Diferentes tipos de botones (`ElevatedButton`, `TextButton`, `OutlinedButton`, `IconButton`, `FloatingActionButton`) que actualizan el estado o muestran diálogos/snackbars.
    3.  **`selection_screen.dart`**
        *   **Título:** Elementos de Selección (Checkbox, Radio, Switch)
        *   **Explicación:** Permiten a los usuarios elegir entre varias opciones o activar/desactivar configuraciones.
        *   **Demostración:**
            *   `Checkbox`: Para selección múltiple.
            *   `Radio`: Agrupados para selección única.
            *   `Switch`: Para activar/desactivar.
            *   Se muestra el estado actual de las selecciones, gestionado con `StatefulWidget` y `setState`.
    4.  **`lists_screen.dart`**
        *   **Título:** Listas (ListView / ListView.builder)
        *   **Explicación:** Muestran colecciones de datos de manera eficiente y desplazable.
        *   **Demostración:** Un `ListView.builder` que muestra una lista de ítems. Interacción con `ListTile` (ej. `onTap`, `trailing` para acciones).
    5.  **`info_elements_screen.dart`**
        *   **Título:** Elementos de Información (Text, Image, CircularProgressIndicator, LinearProgressIndicator)
        *   **Explicación:** Muestran información estática o dinámica al usuario.
        *   **Demostración:**
            *   `Text` widget con diferentes `TextStyle`.
            *   `Image` widget (desde assets o network).
            *   `CircularProgressIndicator` y `LinearProgressIndicator`.

### 🛠️ Requisitos Técnicos (Flutter)

*   Uso de **`StatefulWidget`** y **`StatelessWidget`** de manera apropiada para gestionar el estado de la UI.
*   Implementación de la navegación usando `Navigator` (ej. `Navigator.push`, `Navigator.pop`) o un paquete de gestión de rutas más avanzado si se desea (como `go_router` o `auto_route`).
*   Uso de `BottomNavigationBar` o `TabBar` con `TabController` para la navegación principal.
*   Manejo de estado (usando `setState` para estado local o soluciones más avanzadas como Provider, Riverpod, BLoC/Cubit para estado más complejo o compartido).

---


### Flutter

1.  Clona el repositorio (o la carpeta del proyecto Flutter).
2.  Abre el proyecto en tu editor preferido (VS Code con la extensión Flutter, Android Studio con el plugin Flutter, etc.).
3.  Asegúrate de tener el SDK de Flutter instalado y configurado correctamente.
4.  Conecta un emulador/simulador o un dispositivo físico.
5.  Ejecuta `flutter pub get` en la terminal dentro del directorio del proyecto Flutter.
6.  Ejecuta `flutter run` en la terminal o usa la opción de ejecución de tu IDE.

---

## 💡 Funcionalidad que Conecte Diferentes Fragments/Pantallas 

Para cumplir con el requisito de "Funcionalidad que conecte diferentes fragments", se podría implementar:

*   **En Flutter:** Desde `buttons_screen.dart`, un botón podría navegar a `info_elements_screen.dart` pasando un argumento a través del constructor de la pantalla o usando los argumentos de `Navigator.pushNamed`.

Este README proporciona una visión general del proyecto, su estructura y cómo interactuar con él. ¡Explora las diferentes secciones para aprender sobre los elementos de UI!


https://github.com/user-attachments/assets/21dbe00b-ad4e-4b3e-98de-785b207d9a75
