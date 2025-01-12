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
import data.repository.FirestoreRepository

@Composable
fun CreateAccountScreen(navController: androidx.navigation.NavController,
                        firestoreRepository: FirestoreRepository)
{
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Imaginea de sus
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Create Account Illustration",
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
            verticalArrangement = Arrangement.spacedBy(16.dp) // Spațiu între elemente
        ) {
            Spacer(modifier = Modifier.height(200.dp)) // Spațiu pentru imagine

            // Titlu
            Text(
                text = "Create Account",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6200EE),
                textAlign = TextAlign.Center
            )

            // Câmp Username
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_account_circle_24), // Icon pentru username
                        contentDescription = "Username Icon"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE3F2FD)), // Fundal ușor albastru
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            // Câmp Email
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Your E-mail") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_email_24), // Icon pentru email
                        contentDescription = "Email Icon"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE3F2FD)), // Fundal ușor albastru
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            // Câmp Parolă
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Create Password") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_lock_outline_24), // Icon pentru parolă
                        contentDescription = "Password Icon"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE3F2FD)), // Fundal ușor albastru
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Buton de creare cont
            Button(
                onClick = {
                    firestoreRepository.addUser(
                        username= username,
                        email = email,
                        password = password,
                        onSuccess = { navController.navigate("login") },
                        onFailure = { println("Error: ${it.message}") }
                    )
                    navController.navigate("login")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6200EE))
            ) {
                Text(
                    text = "Create",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
