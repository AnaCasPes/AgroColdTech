package com.example.agrocoldtech


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.sp
import com.example.agrocoldtech.R



@Composable
fun InicioSesion(
    onLoginSuccess: (rol: String, correo: String) -> Unit={_,_->},
    onForgotPasswordClick: () -> Unit= {}
) {
    var rolInput by rememberSaveable { mutableStateOf("") }
    var correoInput by rememberSaveable { mutableStateOf("") }
    var contraseñaInput by rememberSaveable { mutableStateOf("") }

    var errorFormulario by rememberSaveable {mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ){
    Spacer(modifier= Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(120.dp)
            )

            Text(
                text="AGROCOLD TECH",
                fontWeight = FontWeight.Bold,
                fontSize = 38.sp
            )

        }
        Spacer(modifier= Modifier.height(10.dp))

        HorizontalDivider(
            modifier=Modifier.width(290.dp),
            thickness = 2.dp,
            color = Color(0xFFC7F3D1)
        )
        Spacer(modifier= Modifier.height(30.dp))

        OutlinedTextField(
            value = rolInput,
            onValueChange = {rolInput=it},
            label = {Text("Rol")},
            modifier=Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = correoInput,
            onValueChange = {correoInput=it},
            label={Text("Correo electrónico")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier=Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = contraseñaInput,
            onValueChange = {contraseñaInput=it},
            label={Text("Contraseña")},
            modifier=Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType= KeyboardType.Password),
            shape = RoundedCornerShape(12.dp)
        )

        if (errorFormulario != null) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = errorFormulario!!,
                color = MaterialTheme.colorScheme.error,
                fontWeight = FontWeight.Medium
            )
        }
        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                if(correoInput.isBlank() || contraseñaInput.isBlank()){
                    errorFormulario="Completa el correo y la contraseña para iniciar sesión"
                }else{
                    errorFormulario=null
                    onLoginSuccess(rolInput.trim(), correoInput.trim())
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD4F8DC),
                contentColor = Color.Black
            )
        ) {
            Text(
                text= "Iniciar sesión",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold)

        }
        Spacer(modifier=Modifier.height(100.dp))

        Box(
            modifier= Modifier
                .clickable(
                    role = Role.Button,
                    onClick = onForgotPasswordClick
                )
        ) {

            Text(
                text = "¿Olvidaste la contraseña?",
                fontWeight = FontWeight.Bold
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaSeleccionCamarasPreview() {
    InicioSesion()
    }
