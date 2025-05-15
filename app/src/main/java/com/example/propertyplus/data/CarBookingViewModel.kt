package com.example.propertyplus.data

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

data class CarBooking(
    val idNumber: String,
    val fullName: String,
    val mobileNumber: String,
    val clientPhotoUri: String,
    val pickupLocation: String,
    val returnLocation: String,
    val pickupDate: String,
    val returnDate: String,
    val selectedCarType: String,
    val gpsSelected: Boolean,
    val childSeatSelected: Boolean
)

class CarBookingViewModel : ViewModel() {
    private val _idNumber = mutableStateOf("")
    val idNumber: State<String> get() = _idNumber

    private val _fullName = mutableStateOf("")
    val fullName: State<String> get() = _fullName

    private val _mobileNumber = mutableStateOf("")
    val mobileNumber: State<String> get() = _mobileNumber

    private val _clientPhotoUri = mutableStateOf("")
    val clientPhotoUri: State<String> get() = _clientPhotoUri

    private val _pickupLocation = mutableStateOf("")
    val pickupLocation: State<String> get() = _pickupLocation

    private val _returnLocation = mutableStateOf("")
    val returnLocation: State<String> get() = _returnLocation

    private val _pickupDate = mutableStateOf("")
    val pickupDate: State<String> get() = _pickupDate

    private val _returnDate = mutableStateOf("")
    val returnDate: State<String> get() = _returnDate

    private val _selectedCarType = mutableStateOf("")
    val selectedCarType: State<String> get() = _selectedCarType

    private val _gpsSelected = mutableStateOf(false)
    val gpsSelected: State<Boolean> get() = _gpsSelected

    private val _childSeatSelected = mutableStateOf(false)
    val childSeatSelected: State<Boolean> get() = _childSeatSelected

    fun updateField(field: String, value: String) {
        when (field) {
            "idNumber" -> _idNumber.value = value
            "fullName" -> _fullName.value = value
            "mobileNumber" -> _mobileNumber.value = value
            "clientPhotoUri" -> _clientPhotoUri.value = value
            "pickupLocation" -> _pickupLocation.value = value
            "returnLocation" -> _returnLocation.value = value
            "pickupDate" -> _pickupDate.value = value
            "returnDate" -> _returnDate.value = value
            "selectedCarType" -> _selectedCarType.value = value
        }
    }

    fun updateBooleanField(field: String, value: Boolean) {
        when (field) {
            "gpsSelected" -> _gpsSelected.value = value
            "childSeatSelected" -> _childSeatSelected.value = value
        }
    }

    fun submitBooking(onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            if (_idNumber.value.isEmpty() || _fullName.value.isEmpty() || _mobileNumber.value.isEmpty() ||
                _pickupLocation.value.isEmpty() || _returnLocation.value.isEmpty() || _pickupDate.value.isEmpty() ||
                _returnDate.value.isEmpty() || _selectedCarType.value.isEmpty()) {
                onError("Please fill in all fields.")
            } else {
                val booking = CarBooking(
                    idNumber = _idNumber.value,
                    fullName = _fullName.value,
                    mobileNumber = _mobileNumber.value,
                    clientPhotoUri = _clientPhotoUri.value,
                    pickupLocation = _pickupLocation.value,
                    returnLocation = _returnLocation.value,
                    pickupDate = _pickupDate.value,
                    returnDate = _returnDate.value,
                    selectedCarType = _selectedCarType.value,
                    gpsSelected = _gpsSelected.value,
                    childSeatSelected = _childSeatSelected.value
                )
                saveBookingToFirestore(booking, onSuccess, onError)
            }
        }
    }

    private fun saveBookingToFirestore(
        booking: CarBooking,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        val db = FirebaseFirestore.getInstance()
        val bookingRef = db.collection("car_bookings").document()
        bookingRef.set(booking)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener { e ->
                onError("Failed to submit booking: ${e.message}")
            }
    }
}
