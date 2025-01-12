package com.example.theapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.theapp.R

@Composable
fun WelcomeBackScreen(
    onSetGoalClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onViewProgressClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Imaginea de fundal
        Image(
            painter = painterResource(id = R.drawable.analyze_data),
            contentDescription = "Welcome Illustration",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .size(600.dp)
        )

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            // Mesaj de bun venit
            Text(
                text = "Welcome back!",
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6200EE),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Choose your activity",
                fontSize = 18.sp,
                color = Color.Blue,
                textAlign = TextAlign.Center
            )

            // Buton "Set Goal"
            Button(
                onClick = { onSetGoalClick() },
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6200EE))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.setting), // Icon pentru Set Goal
                        contentDescription = "Set Goal Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "Set Goal",
                            fontSize = 18.sp,
                            color = Color.White
                        )
                        Text(
                            text = "Manage your daily objectives",
                            fontSize = 12.sp,
                            color = Color.LightGray
                        )
                    }
                }
            }

            // Buton "Notifications"
            Button(
                onClick = { onNotificationsClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6200EE))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.set), // Icon pentru Notifications
                        contentDescription = "Notifications Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "Notifications",
                            fontSize = 18.sp,
                            color = Color.White
                        )
                        Text(
                            text = "Check your updates",
                            fontSize = 12.sp,
                            color = Color.LightGray
                        )
                    }
                }
            }

            // Buton "View Progress"
            Button(
                onClick = { onViewProgressClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6200EE))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.graph_bar_increase), // Icon pentru Progress
                        contentDescription = "View Progress Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "View Progress",
                            fontSize = 18.sp,
                            color = Color.White
                        )
                        Text(
                            text = "Track your achievements",
                            fontSize = 12.sp,
                            color = Color.LightGray
                        )
                    }
                }
            }
        }
    }
}
