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
import com.example.theapp.ui.theme.ResetPasswordScreen
import com.example.theapp.ui.theme.WelcomeBackScreen

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
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("create_account") {
            CreateAccountScreen(navController = navController)
        }
        composable("reset_password") {
            ResetPasswordScreen(navController = navController)
        }
        composable("welcome_back") {
            WelcomeBackScreen(
                onSetGoalClick = { navController.navigate("set_goal") },
                onNotificationsClick = { navController.navigate("notifications") },
                onViewProgressClick = { navController.navigate("view_progress") }
            )
        }

    }
}