package com.example.moviesapp.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.moviesapp.mock.listMovies
import com.example.moviesapp.widgtes.RowMovies

//preview referencia
//https://developer.android.com/jetpack/compose/tooling/previews

//referencia
//https://www.jetpackcompose.net/textstyle-in-jetpack-compose
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, movieId: String?) {
    if (movieId != null) {
        val movie = listMovies.first { it.id == movieId }

        Scaffold(topBar = {
            TopAppBar(title = {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .size(15.dp)
                            .clickable {
                                navController.popBackStack()
                            },
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back to pop"
                    )
                    Spacer(modifier = Modifier.width(100.dp))
                    Text(text = "Movies App")
                }
            })
        }) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                //proprio column serve como scroll , so colocar a propriedad verticalScroll
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .padding(top = it.calculateTopPadding())
                        .verticalScroll(
                            rememberScrollState()
                        )

                ) {
                    RowMovies(movie = movie, handleClickCard = {})
                    Divider(modifier = Modifier.padding(10.dp))
                    Text(
                        text = "Movie Images", style = androidx.compose.ui.text.TextStyle(
                            fontSize = 20.sp
                        )
                    )
                    LazyRow {
                        items(movie.images) {
                            Card(
                                modifier = Modifier
                                    .size(200.dp)
                                    .padding(horizontal = 15.dp, vertical = 20.dp),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 5.dp
                                )
                            ) {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current).data(it)
                                        .build(),
                                    contentDescription = "Image movies",
                                    contentScale = ContentScale.FillHeight
                                )
                            }

                        }
                    }

                }
            }
        }
    }
}

