package persona.com.taller2.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import persona.com.taller2.componentes.BotonPrincipal
import persona.com.taller2.componentes.BotonSecundario
import persona.com.taller2.componentes.InputEmail
import persona.com.taller2.componentes.MensajeInformacion
import persona.com.taller2.componentes.TitutoApp
import persona.com.taller2.datos.usuarios

@Composable
fun RecuperarPasswordScreen(
    onVolverALogin: () -> Unit
) {
    var correo by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(36.dp)
    ){


    TitutoApp("Recuperar Contraseña")

    InputEmail(valor = correo, onValorCambia = { correo = it })

    Spacer(modifier = Modifier.height(8.dp))

    BotonPrincipal(texto = "Buscar") {
        val encontrado = usuarios.find { it.correo == correo }
        if (encontrado != null) {
            mensaje = "Se envio un correo para recuperar su contraseña"
        } else {
            mensaje = "No se encontro un usuario con el correo proporcionado"
        }
    }

        BotonSecundario(texto = "Volver" ) {onVolverALogin()}

        MensajeInformacion(texto = mensaje)


    }

}