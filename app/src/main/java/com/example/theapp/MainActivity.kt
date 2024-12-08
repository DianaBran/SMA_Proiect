package com.example.theapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.theapp.ui.theme.CreateAccountScreen
import com.example.theapp.ui.theme.TheAppTheme
import com.example.theapp.ui.theme.LoginScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheAppTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    // Controller pentru navigare
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login" // Ecranul de start
    ) {
        composable("login") {
            LoginScreen(
                onCreateAccountClick = {
                    navController.navigate("create_account")
                }
            )
        }
        composable("create_account") {
            CreateAccountScreen()
        }
    }
}