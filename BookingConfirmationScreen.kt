import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.*

@Composable
fun BookingConfirmationScreen() {
    var isChecked by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        // Animated Checkmark
        AnimatedVisibility(visible = isChecked, enter = fadeIn() + expandIn(), exit = fadeOut() + shrinkOut()) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Booking Confirmed",
                tint = Color.Green,
                modifier = Modifier.size(100.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        // Booking Details
        Text(text = "Your Booking is Confirmed!", style = MaterialTheme.typography.h5)
        Text(text = "Booking ID: 123456789", style = MaterialTheme.typography.body1)
        Text(text = "Date: 2026-03-24", style = MaterialTheme.typography.body1)
        Text(text = "Time: 07:47", style = MaterialTheme.typography.body1)

        Spacer(modifier = Modifier.height(20.dp))
        // Receipt
        Text(text = "Receipt:", style = MaterialTheme.typography.h6)
        Text(text = "- Item 1: $100", style = MaterialTheme.typography.body1)
        Text(text = "- Item 2: $200", style = MaterialTheme.typography.body1)

        Spacer(modifier = Modifier.height(20.dp))
        // Action Buttons
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = { /* Do something */ }) {
                Text(text = "Share")
            }
            Button(onClick = { /* Do something */ }) {
                Text(text = "Cancel Booking")
            }
        }
    }

    LaunchedEffect(Unit) {
        isChecked = true // Show checkmark after loading
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBookingConfirmationScreen() {
    BookingConfirmationScreen()
}