package com.example.propertyplus.model

// CarBooking.kt - The data model for a car booking
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





