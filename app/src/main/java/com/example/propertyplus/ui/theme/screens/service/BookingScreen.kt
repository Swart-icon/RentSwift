// BookingScreen.kt

package com.example.propertyplus.ui.theme.screens.service

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.InputType
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.propertyplus.R
import com.example.propertyplus.databinding.ActivityBookingScreenBinding

class BookingScreen : AppCompatActivity() {

    private lateinit var binding: ActivityBookingScreenBinding

    // ViewModel for handling booking data
    private lateinit var viewModel: BookingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDatePicker()
        setupListeners()
        observeViewModel()
    }

    private fun setupDatePicker() {
        binding.editTextDate.inputType = InputType.TYPE_NULL
        binding.editTextDate.setOnClickListener { showDatePickerDialog() }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
            val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            binding.editTextDate.setText(date)
        }, year, month, day).show()
    }

    private fun setupListeners() {
        binding.buttonBook.setOnClickListener { validateAndBook() }
        binding.editTextName.doAfterTextChanged { validateName(it.toString()) }
    }

    private fun validateAndBook() {
        val name = binding.editTextName.text.toString()
        val date = binding.editTextDate.text.toString()

        if (validateName(name) && validateDate(date)) {
            // Proceed with booking
            Toast.makeText(this, "Booking confirmed for $name on $date", Toast.LENGTH_SHORT).show()
            // Call your ViewModel to process the booking
        } else {
            Toast.makeText(this, "Please fix the errors before booking.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateName(name: String): Boolean {
        return if (name.isEmpty()) {
            binding.editTextName.error = "Name cannot be empty"
            false
        } else {
            binding.editTextName.error = null
            true
        }
    }

    private fun validateDate(date: String): Boolean {
        return if (date.isEmpty()) {
            binding.editTextDate.error = "Please select a date"
            false
        } else {
            binding.editTextDate.error = null
            true
        }
    }

    private fun observeViewModel() {
        // Observe LiveData from ViewModel and update UI accordingly
    }
}