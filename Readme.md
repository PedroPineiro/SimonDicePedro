# PMDM - Pedro Piñeiro Ordax
## Simon Dice


Este proyecto es una versión del clásico juego "Simon Dice", desarrollado utilizando Kotlin y Jetpack Compose para gestionar la interfaz de usuario. El objetivo principal del juego es que el usuario observe una secuencia de colores y luego intente reproducirla correctamente.

## Estructura del Proyecto

### `MainViewModel.kt`
El archivo `MainViewModel.kt` contiene la lógica central del juego. Se encarga de manejar el estado y la lógica del juego, siendo el ViewModel principal de la aplicación.

- **Atributos:**
  - `errorMessage`: Un `StateFlow` que almacena los mensajes de error que se muestran al usuario.
  - `colors`: Una lista de los colores que pueden ser seleccionados durante el juego.

- **Métodos:**
  - `startNewGame()`: Reinicia el juego, limpiando la secuencia y comenzando con un nuevo color.
  - `addColorToSequence()`: Añade un color aleatorio a la secuencia del juego y lo muestra al usuario.
  - `showSequence()`: Muestra la secuencia de colores de manera visual para que el usuario la siga.
  - `userInput(color: Color)`: Recibe un color que el usuario selecciona y lo añade a su secuencia.
  - `checkUserSequence()`: Verifica si la secuencia proporcionada por el usuario es correcta.
  - `clearErrorMessage()`: Borra el mensaje de error mostrado.

### `IU.kt`
Este archivo contiene las funciones composables que crean la interfaz de usuario del juego, permitiendo al usuario interactuar con el juego.

- **Funciones Composables:**
  - `interfazColores()`: La interfaz principal que muestra el puntaje y los botones con los colores del juego.
  - `Botones()`: Define los botones de colores visibles en la pantalla.
  - `BotonVerde()`, `BotonRosa()`, `BotonAzul()`, `BotonNaranja()`: Son los botones individuales que corresponden a cada color en el juego.

### `MainViewModelFactory.kt`
La clase `MainViewModelFactory.kt` es responsable de crear instancias de `MainViewModel`.

- **Métodos:**
  - `create(modelClass: Class<T>): T`: Permite crear un objeto `MainViewModel` usando un `RecordRepository`.

### `Datos.kt`
Este archivo contiene una data class que maneja el récord del jugador.

- **Atributos:**
  - `record`: Un valor entero que representa el récord actual del jugador en el juego.
