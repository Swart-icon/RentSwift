package com.example.propertyplus.screens.service

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.propertyplus.navigation.ROUT_BOOKING

@Composable
fun ServiceScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Our Services",
            style = MaterialTheme.typography.headlineMedium
        )

        val services = listOf(
            "Wide range of vehicle types: SUVs, Sedans, Hatchbacks, and more",
            "24/7 Roadside Assistance and Emergency Support",
            "Flexible Pickup and Return Locations",
            "Chauffeur Services Available on Request",
            "Comprehensive Vehicle Insurance Options",
            "Affordable Daily, Weekly, and Monthly Rental Plans",
            "GPS, Wi-Fi, and Child Seat Add-ons",
            "Easy Online Booking and Mobile App Support"
        )

        services.forEach { service ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Text(
                    text = service,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        // Testimonials
        Text(
            text = "What Our Customers Say",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(top = 24.dp)
        )

        Card(modifier = Modifier.fillMaxWidth()) {
            Text(
                "\"Great service and very clean cars!\" - Alex",
                modifier = Modifier.padding(16.dp)
            )
        }
        Card(modifier = Modifier.fillMaxWidth()) {
            Text(
                "\"Flexible pickup options helped a lot.\" - Priya",
                modifier = Modifier.padding(16.dp)
            )
        }

        // Contact Info
        Text(
            text = "Need Help?",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(top = 24.dp)
        )
        Text("Call us: +254 7456 78900")
        Text("Email: kingswart1234@gmail.com")

        // Call to Action
        Button(
            onClick = {
                navController.navigate(ROUT_BOOKING) // Replace with your booking route
            },
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
        ) {
            Text("Book a Car Now")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServiceScreenPreview() {
    ServiceScreen(rememberNavController())
}
