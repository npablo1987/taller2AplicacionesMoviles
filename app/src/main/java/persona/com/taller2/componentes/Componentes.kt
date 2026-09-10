package persona.com.taller2.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TitutoApp(texto: String = "Enfermería Escucha"){
    Text(
        text = texto,
        style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun InputTexto(
    valor: String,
    etiqueta: String,
    onValorCambia: (String) -> Unit,
    teclado: KeyboardType = KeyboardType.Text
){
    OutlinedTextField(
        value = valor,
        onValueChange = onValorCambia,
        label = { Text(etiqueta)},
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = teclado),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    )
}

@Composable
fun InputEmail(
    valor: String,
    onValorCambia: (String) -> Unit
){
    InputTexto(
        valor = valor,
        etiqueta = "Correo electrónico",
        onValorCambia = onValorCambia,
        teclado = KeyboardType.Email
    )
}

@Composable
fun InputPassword(
    valor: String,
    onValorCambia: (String) -> Unit,
    etiqueta: String = "Contraseña"
){
    OutlinedTextField(
        value = valor,
        onValueChange = onValorCambia,

        label = { Text(etiqueta)},
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    )
}

@Composable
fun BotonPrincipal(
    texto: String,
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(text = texto)
    }
}


@Composable
fun BotonSecundario(
    texto: String,
    onClick: () -> Unit
){
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = texto)
    }
}

@Composable
fun TextoEnlace(
    texto: String,
    onClick: () -> Unit
){
    TextButton(onClick = onClick) {
        Text(text = texto)
    }

}



@Composable
fun MensajeInformacion(
    texto: String
){
    if(texto.isNotEmpty()){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = texto,
                modifier = Modifier.padding(12.dp))
        }

    }
}