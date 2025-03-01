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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import com.example.theapp.R
import data.repository.FirestoreRepository


@Composable
fun LoginScreen(navController: androidx.navigation.NavController,
                firestoreRepository: FirestoreRepository
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginError by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Fundal și imagini plasate strategic
        Image(
            painter = painterResource(id = R.drawable.listening_to_feedback), // Fundal principal
            contentDescription = "Background image with girl",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .size(300.dp)

        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Titlu
            Text(
                text = "Hello!",
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6200EE),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Sign in to your account",
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Câmp Email
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email Address") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_email_24),
                        contentDescription = "Email Icon"
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Câmp Parolă
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_lock_outline_24),
                        contentDescription = "Password Icon"
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Mesaj eroare
            if (loginError != null) {
                Text(
                    text = loginError ?: "",
                    color = MaterialTheme.colors.error,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Text Forgot Password
            TextButton(
                onClick = {
                    navController.navigate("reset_password") // Navigare către ecranul ResetPassword
                }
            ) {
                Text(
                    text = "Forgot your password?",
                    color = Color(0xFF1E88E5),
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Buton Log In
            Button(
                onClick = {
                    firestoreRepository.getUsers(
                        onSuccess = { result ->
                            val userExists = result.documents.any { document ->
                                document.getString("email") == email && document.getString("password") == password
                            }

                            if (userExists) {
                                loginError = null
                                navController.navigate("welcome_back")
                            } else {
                                loginError = "Invalid email or password"
                            }
                        },
                        onFailure = { exception ->
                            loginError = "Error: ${exception.message}"
                        }
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6200EE))
            ) {
                Text(
                    text = "Log In",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Navigare la Create Account
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Don't have an account? ",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                TextButton(onClick = {
                    navController.navigate("create_account")
                }) {
                    Text(
                        text = "Create one",
                        fontSize = 14.sp,
                        color = Color(0xFF1E88E5)
                    )
                }
            }
        }

        // Imagine jos
        Image(
            painter = painterResource(id = R.drawable.filling_survey),
            contentDescription = "User Survey Image",
            modifier = Modifier
                .size(250.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        )
    }
}