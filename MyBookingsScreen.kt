import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

data class Booking(
    val carName: String,
    val bookingId: String,
    val status: String,
    val pickupDate: String,
    val returnDate: String,
    val location: String,
    val totalPrice: String
)

@Composable
fun MyBookingsScreen(bookings: List<Booking>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(bookings) { booking ->
            ExpandableBookingCard(booking)
        }
    }
}

@Composable
fun ExpandableBookingCard(booking: Booking) {
    var expanded by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val badgeColor = remember { Animatable(Color.Gray) }

    LaunchedEffect(booking.status) {
        badgeColor.animateTo(
            when (booking.status) {
                "Confirmed" -> Color.Green
                "Pending" -> Color.Yellow
                "Cancelled" -> Color.Red
                else -> Color.Gray
            },
            animationSpec = tween(durationMillis = 500)
        )
    }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = booking.carName, fontSize = 20.sp)
            Text(text = "Booking ID: ${booking.bookingId}")
            Text(text = "Status: ", color = badgeColor.value)
            Text(text = "Pickup: ${booking.pickupDate}")
            Text(text = "Return: ${booking.returnDate}")
            Text(text = "Location: ${booking.location}")
            Text(text = "Total Price:  ${booking.totalPrice}")

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {/* Navigate to details */}) {
                    Text(text = "Details")
                }
                Button(onClick = {/* Navigate to modify booking */}) {
                    Text(text = "Modify")
                }
            }
        }
        if (expanded) {
            // Additional content for expansion
        }
    }
}
