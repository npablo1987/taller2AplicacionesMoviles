package persona.com.taller2.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import persona.com.taller2.componentes.BotonPrincipal
import persona.com.taller2.componentes.BotonSecundario
import persona.com.taller2.componentes.InputEmail
import persona.com.taller2.componentes.InputPassword
import persona.com.taller2.componentes.InputTexto
import persona.com.taller2.componentes.MensajeInformacion
import persona.com.taller2.componentes.TitutoApp
import persona.com.taller2.datos.usuarios
import persona.com.taller2.modelo.Usuario

@Composable
fun RegistroScreen(
    onVolverALogin: () -> Unit

) {
    var nombre by remember { mutableStateOf("") }
    var rut by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var mensaje by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)
    ) {

        TitutoApp("Registro")

        InputTexto(
            valor = nombre,
            onValorCambia = { nombre = it },
            etiqueta = "Nombre"
        )

        InputTexto(
            valor = rut,
            onValorCambia = { rut = it },
            etiqueta = "Rut"
        )

        InputEmail(
            valor = correo,
            onValorCambia = { correo = it }
        )

        InputTexto(
            valor = telefono,
            onValorCambia = { telefono = it },
            etiqueta = "Telefono",
            teclado = KeyboardType.Phone
        )

        InputPassword(
            valor = password,
            onValorCambia = { password = it },
            etiqueta = "Contraseña"
        )
        Spacer(modifier = Modifier.height(8.dp))

        BotonPrincipal(texto = "Registrar") {
            mensaje = when {
                nombre.isEmpty() || rut.isEmpty() || correo.isEmpty() || telefono.isEmpty() || password.isEmpty() -> "Todos los campos son obligatorios"
                !correo.contains("@") -> "Correo electrónico no válido"
                password.length < 8 -> "La contraseña debe tener al menos 8 caracteres"
                else -> {
                    usuarios.add(Usuario(nombre, rut, correo, telefono, password))
                    "Usuario registrado exitosamente"
                }

            }

        }

        BotonSecundario(texto = "Volver") { onVolverALogin() }

        MensajeInformacion(texto = mensaje)
    }
}