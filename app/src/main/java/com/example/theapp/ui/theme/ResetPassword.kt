package com.example.theapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.theapp.R

@Composable
fun ResetPasswordScreen(navController: androidx.navigation.NavController) {
    var newPassword by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Imaginea de sus
        Image(
            painter = painterResource(id = R.drawable.asking_a_question), // Înlocuiește cu imaginea potrivită
            contentDescription = "Reset Password Illustration",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Dimensiune ajustabilă
                .align(Alignment.TopCenter)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.height(200.dp)) // Spațiu pentru imagine

            // Titlu
            Text(
                text = "Reset Password",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6200EE),
                textAlign = TextAlign.Center
            )

            // Câmp pentru parolă nouă
            TextField(
                value = newPassword,
                onValueChange = { newPassword = it },
                label = { Text("New Password") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_lock_outline_24), // Icon pentru parolă
                        contentDescription = "Password Icon"
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.eye_closed), // Icon pentru vizibilitate
                        contentDescription = "Show Password",
                        modifier = Modifier.size(24.dp)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE3F2FD)), // Fundal ușor albastru
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Buton pentru resetarea parolei
            Button(
                onClick = {
                    navController.navigate("login")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6200EE))
            ) {
                Text(
                    text = "Reset Password",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
