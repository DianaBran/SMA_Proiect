package com.example.theapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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

@Composable
fun NotificationsScreen(navController: androidx.navigation.NavController) {
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
                .align(Alignment.TopStart)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "Back Arrow",
                tint = Color(0xFF4A90E2)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Titlu
            Text(
                text = "Notifications",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6200EE),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Secțiunea "Today"
            Text(
                text = "Today",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0x7C5CF5),
                modifier = Modifier.fillMaxWidth()
            )

            NotificationCard(
                title = "GOAL COMPLETED!",
                description = "You've achieved your hydration goal",
                backgroundColor = Color(0xFFB9FBC0),
                time = "2h ago",
                iconResId = R.drawable.check3
            )

            NotificationCard(
                title = "REMINDER",
                description = "Time to update your to-do list",
                backgroundColor = Color(0xFFD6E4FF),
                time = "1h ago",
                iconResId = R.drawable.alarm
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Secțiunea "Yesterday"
            Text(
                text = "Yesterday",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0x7C5CF5),
                modifier = Modifier.fillMaxWidth()
            )

            NotificationCard(
                title = "MISSED GOAL",
                description = "You didn't complete your eating habits goal",
                backgroundColor = Color(0xFFD6E4FF),
                time = "1d ago",
                iconResId = R.drawable.calendarcross
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Text final
            Text(
                text = "NO MORE NOTIFICATIONS",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )

            // Imagine jos
            Image(
                painter = painterResource(id = R.drawable.group),
                contentDescription = "Empty Notifications",
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun NotificationCard(
    title: String,
    description: String,
    backgroundColor: Color,
    time: String,
    iconResId: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = iconResId),
                    contentDescription = title,
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Column {
                    Text(
                        text = title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = description,
                        fontSize = 14.sp,
                        color = Color.DarkGray
                    )
                }
            }

            Text(
                text = time,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}
