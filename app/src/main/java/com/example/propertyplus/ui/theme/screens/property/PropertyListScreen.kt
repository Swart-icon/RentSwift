package com.example.propertyplus.screens.property


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.propertyplus.data.PropertyViewModel
import com.example.propertyplus.model.Property
import com.example.propertyplus.navigation.ROUT_ADD_PROPERTY
import com.google.firebase.auth.FirebaseAuth

@Composable
fun PropertyListScreen(navController: NavHostController) {
    val context = LocalContext.current
    val propertyViewModel = remember { PropertyViewModel(navController, context) }

    val selectedProperty = remember { mutableStateOf(Property("", "", "", "", "", "")) }
    val propertyList = remember { mutableStateListOf<Property>() }

    val currentUser = FirebaseAuth.getInstance().currentUser
    val currentUserId = currentUser?.uid

    val properties = propertyViewModel.allProperties(selectedProperty, propertyList)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(30.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        TextButton(
            onClick = { navController.navigate(ROUT_ADD_PROPERTY) }
        ) {
            Text(text = "Add New Car")
        }


        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Car Listings",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(properties) { property ->
                if (property.userId == currentUserId) {
                    PropertyItem(
                        property = property,
                        onUpdate = {
                            navController.navigate("edit_property_screen/${property.id}")
                        },
                        onDelete = { propertyViewModel.deleteProperty(property.id) }
                    )
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(24.dp))
    TextButton(
        onClick = { navController.navigate(ROUT_ADD_PROPERTY) }
    ) {
        Text(text = "Back")
    }
}

@Composable
fun PropertyItem(
    property: Property,
    onUpdate: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Title: ${property.title}", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = "Description: ${property.description}", fontSize = 14.sp)
            Text(text = "Price: ${property.price}", fontSize = 14.sp)
            Text(text = "Location: ${property.location}", fontSize = 14.sp)

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedButton(onClick = onUpdate) {
                    Icon(Icons.Default.Edit, contentDescription = "Update")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Update")
                }
                Button(onClick = onDelete, colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Delete", color = Color.White)
                }
            }
        }
    }
}