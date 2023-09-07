package com.example.moviesapp.route

import java.lang.IllegalArgumentException

enum class MovieScreens  {
    DetailsScreen,
    HomeScreen;

    companion object  {
        fun fromRoute(route: String?): MovieScreens = when (route?.substringBefore(delimiter = "/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            else -> throw  IllegalArgumentException("Route $route is not regonizable")
        }
    }

}