package com.example.moviesapp.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.moviesapp.mock.listMovies
import com.example.moviesapp.route.MovieScreens
import com.example.moviesapp.ui.theme.MoviesAppTheme
import com.example.moviesapp.widgtes.RowMovies


@Composable
fun HomeScreen(navController: NavController) {
    MyApp {
        MainContent(it, navController)
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(content: @Composable (PaddingValues) -> Unit) {
    MoviesAppTheme {
        Scaffold(topBar = {
            Surface() {
                TopAppBar(
                    title = { Text(text = "Movies App") },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color.Transparent,
                        titleContentColor = MaterialTheme.colorScheme.secondary
                    )
                )
            }
        }) {
            content(it)
        }
    }
}


@Composable
fun MainContent(paddingValues: PaddingValues, navController: NavController) {
    //precisa do padding
    Surface(modifier = Modifier.padding(top = paddingValues.calculateTopPadding())) {
        LazyColumn {
            items(items = listMovies) {
                RowMovies(it) {
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/$it")
                }
            }
        }
    }
}


