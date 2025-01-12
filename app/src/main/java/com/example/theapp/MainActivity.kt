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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.theapp.ui.theme.CreateAccountScreen
import com.example.theapp.ui.theme.TheAppTheme
import com.example.theapp.ui.theme.LoginScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.theapp.ui.theme.NotificationsScreen
import com.example.theapp.ui.theme.ResetPasswordScreen
import com.example.theapp.ui.theme.SetGoalScreen
import com.example.theapp.ui.theme.WelcomeBackScreen
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.SetOptions
import data.repository.FirestoreRepository
import com.example.theapp.ui.theme.ProgressScreen


class MainActivity : ComponentActivity() {
    private val db = FirebaseFirestore.getInstance() // Instanță Firebase Firestore
    private val firestoreRepository = FirestoreRepository(db)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheAppTheme {
                AppNavigation(firestoreRepository)
            }
        }
    }
}

@Composable
fun AppNavigation(firestoreRepository: FirestoreRepository) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(navController = navController, firestoreRepository = firestoreRepository)
        }
        composable("create_account") {
            CreateAccountScreen(navController = navController, firestoreRepository = firestoreRepository)
        }
        composable("reset_password") {
            ResetPasswordScreen(navController = navController, firestoreRepository = firestoreRepository)
        }
        composable("set_goal") {
            SetGoalScreen(navController = navController)
        }
        composable("notifications") {
            NotificationsScreen(navController = navController)
        }
        composable("progress") {
            ProgressScreen(navController = navController)
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
