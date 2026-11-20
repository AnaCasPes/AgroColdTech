package com.example.agrocoldtech

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.agrocoldtech.ui.theme.AgroColdTechTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

private enum class PantallaApp {
    INICIO_SESION,
    SELECCION,

    CAMARAS,
    QR,
    FUNCIONAMIENTO_1,

    FUNCIONAMIENTO_2
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AgroColdTechTheme {
                AppAgroColdTech()
            }
        }
    }
}

@Composable
private fun AppAgroColdTech() {
    var pantallaActual by remember { mutableStateOf(PantallaApp.INICIO_SESION) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (pantallaActual) {
                PantallaApp.INICIO_SESION -> {
                    InicioSesion(
                        onLoginSuccess = { rol, correo ->
                            pantallaActual = PantallaApp.SELECCION
                        },
                        onForgotPasswordClick = {
                        }
                    )
                }

                PantallaApp.SELECCION -> {
                    PantallaSeleccion(
                        onMenuClick = {
                        },
                        onNotificactionsClick = {
                        },
                        onLogoutClick = {
                            pantallaActual = PantallaApp.INICIO_SESION
                        },
                        onCamarasClick = {
                            pantallaActual = PantallaApp.CAMARAS
                        },
                        onLectorQRClick = {
                            pantallaActual = PantallaApp.QR
                        },
                        onIncidenciasClick = {
                        }
                    )
                }
                PantallaApp.CAMARAS -> {
                    PantallaCamaras(
                        onMenuClick = {
                        },
                        onNotificationsClick = {
                        },
                        onLogoutClick = {
                            pantallaActual = PantallaApp.INICIO_SESION
                        },
                        onCameraClick = { numeroCamara ->
                            pantallaActual = PantallaApp.FUNCIONAMIENTO_1
                        }
                    )
                }

                PantallaApp.QR -> {
                    QR(
                        onBackClick = {
                            pantallaActual = PantallaApp.SELECCION
                        },
                        onQrClick = {

                        },
                        onMenuClick = {
                        },
                        onNotificationsClick = {
                        },
                        onLogoutClick = {
                            pantallaActual = PantallaApp.INICIO_SESION
                        }
                    )
                }

                PantallaApp.FUNCIONAMIENTO_2 -> {
                    PantallaFuncionamiento2(
                        onMenuClick = {

                        },
                        onNotificationsClick = {

                        },
                        onLogoutClick = {
                            pantallaActual = PantallaApp.INICIO_SESION
                        },
                        onParcelaClick = {
                           //pdf
                        },
                        onCalidadClick = {
                            // pdf
                        }
                    )
                }

                else -> {}
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AgroColdTechTheme {

    }
}