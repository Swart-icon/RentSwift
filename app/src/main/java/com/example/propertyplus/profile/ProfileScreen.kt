package com.example.propertyplus.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.propertyplus.R

@Composable
fun ProfileScreen(navController: NavHostController) {
    // Placeholder user data
    val name = "Evans Koome" // Sample name
    val email = "kingswart1234@gmail.com" // Sample email

    ProfileScreenContent(
        name = name,
        email = email,
        onEditProfile = {
            // Handle edit profile action
        },
        onLogOut = { navController.navigate("login") }
    )
}

@Composable
fun ProfileScreenContent(
    name: String,
    email: String,
    onEditProfile: () -> Unit,
    onLogOut: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Profile Picture
        Card(
            shape = CircleShape,
            modifier = Modifier
                .size(120.dp)
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.me), // Replace with your profile image
                contentDescription = "Profile Image",
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Profile Title
        Text(
            text = "Profile",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Name Text
        Text(
            text = "Name: $name",
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Email Text
        Text(
            text = "Email: $email",
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Edit Profile Button
        Button(
            onClick = onEditProfile,
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text("Edit Profile", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Log Out Button
        Button(
            onClick = onLogOut,
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text("Log Out", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))


    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreenContent(
        name = "Evans Koome",
        email = "kingswart1234@gmail.com",
        onEditProfile = {},
        onLogOut = {}
    )
}
