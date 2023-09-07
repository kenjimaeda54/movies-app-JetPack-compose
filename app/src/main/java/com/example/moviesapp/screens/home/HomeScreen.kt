package com.example.moviesapp.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moviesapp.route.MovieRoute
import com.example.moviesapp.route.MovieScreens
import com.example.moviesapp.ui.theme.MoviesAppTheme

val listMovies = listOf<String>(
    "Harry Porter",
    "Fast and Furious",
    "Demon Slayer"
)

@Composable
fun HomeScreen(navController: NavController) {
    MyApp {
        MainContent(it,navController)
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
                        containerColor = MaterialTheme.colorScheme.secondary,
                        titleContentColor = MaterialTheme.colorScheme.secondaryContainer
                    )
                )
            }
        }) {
            content(it)
        }
    }
}


@Composable
fun MainContent(paddingValues: PaddingValues,navController: NavController) {
    //precisa do padding

    Surface(modifier = Modifier.padding(vertical = paddingValues.calculateTopPadding())) {
        LazyColumn {
            items(items = listMovies) {
                RowMovies(it) {
                    navController.navigate(route = MovieScreens.DetailsScreen.name)
                }
            }
        }
    }

}


@Composable
fun RowMovies(movie: String, handleClickCard: (String) -> Unit) {
    //referencia
    //https://developer.android.com/jetpack/compose/designsystems/material3
    //https://foso.github.io/Jetpack-Compose-Playground/foundation/shape/
    Card(
        modifier = Modifier
            .padding(vertical = 7.dp, horizontal = 12.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                handleClickCard(movie)
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onTertiary
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Surface(
                modifier = Modifier
                    .padding(4.dp)
                    .size(100.dp),
                color = MaterialTheme.colorScheme.onTertiary,
                shape = RoundedCornerShape(10.dp),
                shadowElevation = 4.dp
            ) {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "Image icon movie"
                )
            }
            Text(modifier = Modifier.padding(horizontal = 10.dp), text = movie)
        }
    }

}
