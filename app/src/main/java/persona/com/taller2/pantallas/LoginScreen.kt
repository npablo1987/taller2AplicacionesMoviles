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
import androidx.compose.ui.unit.dp
import persona.com.taller2.componentes.BotonPrincipal
import persona.com.taller2.componentes.InputEmail
import persona.com.taller2.componentes.InputPassword
import persona.com.taller2.componentes.MensajeInformacion
import persona.com.taller2.componentes.TextoEnlace
import persona.com.taller2.componentes.TitutoApp
import persona.com.taller2.datos.usuarios

@Composable
fun LoginScreen(
    onLoginExitoso: () -> Unit,
    onIrRegistro: () -> Unit,
    onIrRecuperar: () -> Unit,
){
    var correo by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ){
        TitutoApp()
        InputEmail(valor = correo, onValorCambia = { correo = it })
        InputPassword(valor = password, onValorCambia = { password = it })
        Spacer(modifier = Modifier.height(8.dp))
        BotonPrincipal(texto = "Iniciar sesión") {
            val encontrado = usuarios.find { it.correo == correo && it.password == password }
            if(encontrado != null){
                mensaje = "Inicio de sesión exitoso"
                onLoginExitoso()
            } else {
                mensaje = "Credenciales incorrectas"
            }
        }

        TextoEnlace(texto = "Crear Cuenta") { onIrRegistro() }

        TextoEnlace(texto = "Recuperar contraseña") { onIrRecuperar() }

        MensajeInformacion(texto = mensaje)

    }

}