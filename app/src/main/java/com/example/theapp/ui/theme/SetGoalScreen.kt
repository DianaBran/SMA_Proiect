package com.example.theapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.theapp.R
import androidx.compose.material.Icon
import androidx.compose.material.IconButton

import androidx.compose.ui.res.painterResource


@Composable
fun SetGoalScreen(navController: androidx.navigation.NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Săgeata de navigare înapoi
        IconButton(
            onClick = { navController.navigate("welcome_back") },
            modifier = Modifier
                .padding(16.dp)
                .size(40.dp)
                .align(Alignment.TopStart) // Aliniere sus stânga
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24), // Icon-ul săgeții
                contentDescription = "Back Arrow",
                tint = Color(0xFF4A90E2) // Culoarea săgeții
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Titlu
            Text(
                text = "Set your goal",
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6200EE),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Butoane pentru obiective
            GoalButton(
                title = "TO DO LIST",
                description = "Add your daily tasks",
                iconId = R.drawable.checksquare,
                onClick = { /* Navighează către ecranul "TO DO LIST" */ }
            )
            GoalButton(
                title = "EATING HABITS",
                description = "Track your meals",
                iconId = R.drawable.chicken_grilled,
                onClick = { /* Navighează către ecranul "EATING HABITS" */ }
            )
            GoalButton(
                title = "HYDRATION",
                description = "Monitor your water intake",
                iconId = R.drawable.waterglass,
                onClick = { /* Navighează către ecranul "HYDRATION" */ }
            )

            // Imaginea de jos
            Image(
                painter = painterResource(id = R.drawable.filling_survey),
                contentDescription = "Illustration",
                modifier = Modifier
                    .size(350.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun GoalButton(title: String, description: String, iconId: Int, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick)
            .background(Color(0xFFE3F2FD))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icon
        Image(
            painter = painterResource(id = iconId),
            contentDescription = "$title Icon",
            modifier = Modifier.size(40.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Text
        Column {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6200EE)
            )
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}
