package com.example.propertyplus.ui.screens.booking

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.propertyplus.R
import com.example.propertyplus.data.CarBookingViewModel
import com.example.propertyplus.navigation.ROUT_ADD_PROPERTY
import com.example.propertyplus.navigation.ROUT_CONTACT
import com.example.propertyplus.navigation.ROUT_HOME
import com.example.propertyplus.navigation.ROUT_PROFILE
import com.example.propertyplus.navigation.ROUT_SERVICE
import com.example.propertyplus.navigation.ROUT_VIEW_PROPERTY
import kotlinx.coroutines.launch

@Composable
fun SimpleBookingScreen(
    navController: NavHostController,
    viewModel: CarBookingViewModel = viewModel()
) {
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    val idNumber by viewModel.idNumber
    val fullName by viewModel.fullName
    val mobileNumber by viewModel.mobileNumber
    val pickupLocation by viewModel.pickupLocation
    val returnLocation by viewModel.returnLocation
    val pickupDate by viewModel.pickupDate
    val returnDate by viewModel.returnDate
    val selectedCarType by viewModel.selectedCarType
    val gpsSelected by viewModel.gpsSelected
    val childSeatSelected by viewModel.childSeatSelected

    Box(modifier = Modifier.fillMaxSize()) {
        // Background image
        Image(
            painter = painterResource(R.drawable.img_5),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        Scaffold(
            backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.85f),
            topBar = {
                TopAppBar(
                    title = { Text("Car Rental Booking") },
                    actions = {
                        IconButton(onClick = { navController.navigate(ROUT_HOME) }) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(Icons.Default.Home, contentDescription = "Home")
                                Text("Home", style = MaterialTheme.typography.body2)
                            }
                        }

                        IconButton(onClick = { navController.navigate(ROUT_SERVICE) }) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(Icons.Default.Build, contentDescription = "Service")
                                Text("Service", style = MaterialTheme.typography.body2)
                            }
                        }

                        IconButton(onClick = { navController.navigate(ROUT_ADD_PROPERTY) }) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(Icons.Default.Add, contentDescription = "Add Property")
                                Text("Add New Car", style = MaterialTheme.typography.body2)
                            }
                        }

                        IconButton(onClick = { navController.navigate(ROUT_PROFILE) }) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(Icons.Default.Person, contentDescription = "Profile")
                                Text("Profile", style = MaterialTheme.typography.body2)
                            }
                        }

                        IconButton(onClick = { navController.navigate(ROUT_CONTACT) }) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(Icons.Default.Call, contentDescription = "Contact")
                                Text("Contact", style = MaterialTheme.typography.body2)
                            }
                        }

                    }
                )
            },
            snackbarHost = { SnackbarHost(snackbarHostState) },
            modifier = Modifier.fillMaxSize()
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Banner image
                Image(
                    painter = painterResource(id = R.drawable.car2),
                    contentDescription = "Banner Image",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .fillMaxWidth()
                        .height(180.dp)
                )

                Text("Booking Form", style = MaterialTheme.typography.h6)

                OutlinedTextField(
                    value = idNumber,
                    onValueChange = { viewModel.updateField("idNumber", it) },
                    label = { Text("ID Number") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = {  })
                )

                OutlinedTextField(
                    value = fullName,
                    onValueChange = { viewModel.updateField("fullName", it) },
                    label = { Text("Full Name") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = {  })
                )

                OutlinedTextField(
                    value = mobileNumber,
                    onValueChange = { viewModel.updateField("mobileNumber", it) },
                    label = { Text("Mobile Number") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = { })
                )

                OutlinedTextField(
                    value = pickupLocation,
                    onValueChange = { viewModel.updateField("pickupLocation", it) },
                    label = { Text("Pickup Location") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = returnLocation,
                    onValueChange = { viewModel.updateField("returnLocation", it) },
                    label = { Text("Return Location") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = pickupDate,
                    onValueChange = { viewModel.updateField("pickupDate", it) },
                    label = { Text("Pickup Date") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = returnDate,
                    onValueChange = { viewModel.updateField("returnDate", it) },
                    label = { Text("Return Date") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = selectedCarType,
                    onValueChange = { viewModel.updateField("selectedCarType", it) },
                    label = { Text("Car Type") },
                    modifier = Modifier.fillMaxWidth()
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = gpsSelected,
                        onCheckedChange = { viewModel.updateBooleanField("gpsSelected", it) }
                    )
                    Text("GPS")
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = childSeatSelected,
                        onCheckedChange = { viewModel.updateBooleanField("childSeatSelected", it) }
                    )
                    Text("Child Seat")
                }

                Button(
                    onClick = {
                        viewModel.submitBooking(
                            onSuccess = {
                                coroutineScope.launch {
                                    snackbarHostState.showSnackbar("Booking Submitted!")
                                    navController.navigate(ROUT_VIEW_PROPERTY)
                                }
                            },
                            onError = { errorMessage ->
                                coroutineScope.launch {
                                    snackbarHostState.showSnackbar(errorMessage)
                                }
                            }
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Text("Submit Booking")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleBookingScreenPreview() {
    SimpleBookingScreen(navController = rememberNavController())
}
