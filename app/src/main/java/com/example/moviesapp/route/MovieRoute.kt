package com.example.moviesapp.route

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviesapp.screens.details.DetailsScreen
import com.example.moviesapp.screens.home.HomeScreen


@Composable
fun MovieRoute()  {
    val navController = rememberNavController()
    NavHost(navController =  navController, startDestination = MovieScreens.HomeScreen.name ) {
        composable(MovieScreens.HomeScreen.name) {
             HomeScreen(navController = navController)
        }

        composable(MovieScreens.DetailsScreen.name) {
            DetailsScreen(navController = navController)
        }
    }

}