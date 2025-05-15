package com.example.propertyplus.navigation

import AddPropertyScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.propertyplus.profile.ProfileScreen
import com.example.propertyplus.screens.about.AboutScreen
import com.example.propertyplus.screens.contact.ContactScreen
import com.example.propertyplus.screens.login.LoginScreen
import com.example.propertyplus.screens.property.EditPropertyScreen
import com.example.propertyplus.screens.property.PropertyListScreen
import com.example.propertyplus.screens.service.ServiceScreen
import com.example.propertyplus.screens.signup.SignupScreen
import com.example.propertyplus.screens.splashscreen.SplashScreen
import com.example.propertyplus.ui.screens.booking.SimpleBookingScreen
import com.example.propertyplus.ui.theme.screens.home.HomeScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    )

    {

        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUT_HOME) {
            HomeScreen(navController)
        }

        composable(ROUT_BOOKING) {
            SimpleBookingScreen(navController)
        }



        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }

        composable(ROUT_CONTACT) {
            ContactScreen(navController)
        }
        composable(ROUT_SERVICE) {
            ServiceScreen(navController)
        }
        composable(ROUT_SIGNUP) {
            SignupScreen(navController)
        }
        composable(ROUT_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUT_ADD_PROPERTY) {
            AddPropertyScreen(navController = navController)
        }
        composable(ROUT_VIEW_PROPERTY) {
            PropertyListScreen(navController = navController)
        }

        composable(ROUT_PROFILE) {
            ProfileScreen(navController)
        }



        composable(
            ROUT_EDIT_PROPERTY,
            arguments = listOf(navArgument("propertyId") { type = NavType.StringType })
        ) {
            val propertyId = it.arguments?.getString("propertyId") ?: ""
            EditPropertyScreen (navController, propertyId)
        }



    }
}

