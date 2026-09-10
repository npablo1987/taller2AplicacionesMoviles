# Taller2

Aplicación Android desarrollada en Kotlin con Jetpack Compose, que implementa un flujo básico de autenticación de usuarios (login, registro y recuperación de contraseña) usando datos en memoria.

## Tecnologías

- **Kotlin**
- **Jetpack Compose** (Material 3)
- **Navigation Compose** para el manejo de pantallas
- Gradle Kotlin DSL (`build.gradle.kts`)

## Requisitos

- Android Studio (versión reciente con soporte para Kotlin Compose)
- JDK 11
- `compileSdk` / `targetSdk`: 37
- `minSdk`: 31

## Estructura del proyecto

```
app/src/main/java/persona/com/taller2/
├── MainActivity.kt          # Punto de entrada y navegación (NavHost)
├── componentes/              # Componentes reutilizables de UI
├── datos/                     # Datos en memoria (usuarios de prueba)
├── modelo/                   # Modelos de datos (Usuario)
├── pantallas/                # Pantallas de la app
│   ├── LoginScreen.kt
│   ├── RegistroScreen.kt
│   ├── RecuperarPasswordScreen.kt
│   └── HomeScreen.kt
└── ui/                        # Tema y estilos de la app
```

## Navegación

La app define las siguientes rutas en `MainActivity.kt`:

| Ruta        | Pantalla                  |
|-------------|----------------------------|
| `login`     | `LoginScreen`              |
| `registro`  | `RegistroScreen`           |
| `recuperar` | `RecuperarPasswordScreen`  |
| `inicio`    | `HomeScreen`               |

El flujo comienza en `login`. Desde ahí se puede navegar a registro, recuperación de contraseña, o iniciar sesión y llegar a la pantalla de inicio.

## Datos de usuario

Actualmente los usuarios se almacenan en memoria en `datos/UsuarioData.kt`, con un límite definido por `MAX_USUARIOS`. El modelo `Usuario` (`modelo/Usuario.kt`) contiene: `nombre`, `rut`, `correo`, `telefono` y `password`.

## Cómo ejecutar

1. Abrir el proyecto en Android Studio.
2. Esperar a que sincronice Gradle.
3. Ejecutar la app en un emulador o dispositivo con Android 12 (API 31) o superior.

También se puede compilar desde la línea de comandos:

```bash
./gradlew assembleDebug
```

## Tests

El proyecto incluye configuración para tests unitarios (JUnit) y tests instrumentados (Espresso, Compose UI Test):

```bash
./gradlew test
./gradlew connectedAndroidTest
```
