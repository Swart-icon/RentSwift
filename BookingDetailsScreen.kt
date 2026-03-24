package com.example.rentswift

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment

class BookingDetailsScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_details)

        // Initialize map here
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync { googleMap: GoogleMap ->
            // Set up map here
        }

        // Set up chat support UI and functionality

        // Set up cancellation option
    }

    // Additional methods for booking information, support chat, and cancellation
}
