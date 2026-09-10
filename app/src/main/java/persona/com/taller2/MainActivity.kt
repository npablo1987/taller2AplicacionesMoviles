package persona.com.taller2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import persona.com.taller2.ui.theme.Taller2Theme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import persona.com.taller2.pantallas.HomeScreen
import persona.com.taller2.pantallas.LoginScreen
import persona.com.taller2.pantallas.RecuperarPasswordScreen
import persona.com.taller2.pantallas.RegistroScreen


private const val RUTA_LOGIN = "login"
private const val RUTA_INICIO = "inicio"
private const val RUTA_REGISTRO = "registro"
private const val RUTA_RECUPERAR = "recuperar"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Taller2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        AppNavigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier){

    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = RUTA_LOGIN,
        modifier = modifier)

    {
        composable(RUTA_LOGIN) {
            LoginScreen(
                onLoginExitoso = {
                    navController.navigate(RUTA_INICIO)
                },
                onIrRegistro = {
                    navController.navigate(RUTA_REGISTRO)
                },
                onIrRecuperar = {
                    navController.navigate(RUTA_RECUPERAR)
                }
            )
        }
        composable (RUTA_REGISTRO){
            RegistroScreen(
                onVolverALogin = {
                    navController.navigate(RUTA_LOGIN)
                }
            )
        }

        composable (RUTA_RECUPERAR){
            RecuperarPasswordScreen(
                onVolverALogin = {
                    navController.popBackStack()
                }
            )
        }
        composable (RUTA_INICIO){
            HomeScreen(
                onCerrarSesion = {
                    navController.popBackStack(RUTA_LOGIN, inclusive = false)
                }
            )
        }


    }


}