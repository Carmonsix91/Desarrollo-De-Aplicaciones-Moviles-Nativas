#### **Ejercicio 1: Instalación de Herramientas**
En este primer ejercicio, deberás instalar y configurar las siguientes herramientas esenciales en tu sistema (macOS, Linux o Windows) para el desarrollo de proyectos de Android.

**Instalación de Herramientas para Desarrollo Android **
- **Android Studio**
**Descarga e instalación**:He descargado Android Studio desde el sitio oficial (developer.android.com) y completado el proceso de instalación; en la ilustración 1 se muestra la web oficial de Android, con un botón en la parte inferior izquierda, que descarga la última versión del IDE de Android Studio. 
Despues de darcargar el instalador, la instalación es como la de cualquier otro programa, lo importante es demostrar como crear un proyecto y un emulador, lo cual se ilustra en la ilustración 1. 

**Ilustración 1: Página oficial de android developers**
	
   **Configuración del IDE**: Configuré el SDK de Android, creé un dispositivo virtual (emulador) y verifiqué que funciona correctamente ejecutando una aplicación de prueba. 

   **Ilustración 2: Menú de creación de proyecto de Android Studio**
   ![Image](https://github.com/user-attachments/assets/8ccca8c8-8608-422b-a12d-da730cda0c8f)
En la Ilustración 2, hay varias plantillas con las cuales se puede empezar un proyecto de Android; las más importantes son 2, las demás son variaciones de dichas plantillas. 
**Plantilla 1: Empty Activity**: Crea una aplicación de Android usando Jetpack Compose como sistema de vistas; por defecto, solo contiene un texto que dice “Hello Android”. 
**Plantilla 2: Empty Views Activity**: Crea una aplicación de Android usando objetos de la clase View como sistema de vistas (vinculados a archivos XML); por defecto, solo contiene un texto que dice “Hello Android”. 
Para este ejemplo, creamos una aplicación usando la plantilla Empty Activity (Ilustración 3), para posteriormente configurar el emulador y ejecutar la aplicación. 

Ilustración 3: Configuración del proyecto a crear en Android Studio. 
![Image](https://github.com/user-attachments/assets/c8bd67b6-8edc-4c24-b2a2-a6b07f3b735e)
Después de crear el proyecto, en la interfaz de Android Studio, en la barra lateral izquierda, se encuentra el icono del Device Manager, el cual se encarga de gestionar los dispositivos emulados (Ilustración 4). 


Ilustración 4: Pantalla principal de Android Studio 
![Image](https://github.com/user-attachments/assets/64de3013-229f-4218-b125-bf9568b2aa84)
Al dar clic en “Add New Device” se desplegará un menú emergente, en el cual daremos clic en “Create virtual device” (Ilustración 5). Posteriormente, al elegir un dispositivo, se pedirá elegir una API de Android; por defecto, puede descargarse la API con la que funciona el dispositivo en la realidad; sin embargo, puede elegirse a gusto del desarrollador. Para este ejemplo, se continuará con el API 36 (Ilustración 6). 
Hay más configuraciones adicionales, como la cantidad de almacenamiento interno del dispositivo, memoria RAM del dispositivo anfitrión que se puede utilizar, cantidad de almacenamiento externo, entre otras. 


Ilustración 5: Selección del dispositivo para la emulación. 
![Image](https://github.com/user-attachments/assets/8a65737c-8c90-463e-8fb9-06e050a4e627)

Ilustración 	6: 	Selección 	del 	nivel 	de 	API  
La imagen del dispositivo se descargará y finalmente tendremos el emulador disponible para ejecutar las aplicaciones que se desarrollen (Ilustración 7). 


Ilustración 7: Ejecuión de la aplicación Hello Android. 
![Image](https://github.com/user-attachments/assets/7d89d3d1-4d64-46ca-99e8-1d234e8fe3c2)

