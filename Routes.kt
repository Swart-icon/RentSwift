// Routes.kt

sealed class Routes {
    companion object {
        const val BOOKING_CONFIRMATION = "/bookingConfirmation"
        const val MY_BOOKINGS = "/myBookings"
        const val BOOKING_DETAILS = "/bookingDetails"
        const val PAYMENT = "/payment"
        const val CAR_LISTING = "/carListing"
        const val CAR_DETAILS = "/carDetails"
        const val FORGOT_PASSWORD = "/forgotPassword"
        const val ABOUT = "/about"
        const val CONTACT = "/contact"
        const val SEARCH = "/search"
        const val SETTINGS = "/settings"
        const val PAYMENT_METHODS = "/paymentMethods"
        const val EDIT_PROFILE = "/editProfile"
        const val MAP = "/map"
    }
}