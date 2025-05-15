package com.example.propertyplus.screens.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AboutScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text("About Car Rental", style = MaterialTheme.typography.headlineMedium)
        Text("We are a reliable car rental service, offering top-quality vehicles and customer care.")
    }
}
@Preview(showBackground = true)
@Composable
fun  AboutScreenPreview(){
    AboutScreen(rememberNavController())
}