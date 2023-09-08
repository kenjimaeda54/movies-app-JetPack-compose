package com.example.moviesapp.widgtes

import android.graphics.fonts.FontStyle
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.moviesapp.mock.listMovies
import com.example.moviesapp.models.MoviesModel

@Composable
fun RowMovies(movie: MoviesModel, handleClickCard: (String) -> Unit) {
    //referencia
    //https://stefma.medium.com/jetpack-compose-remember-mutablestateof-derivedstateof-and-remembersaveable-explained-270dbaa61b8
    var expanded by remember {
        mutableStateOf(false)
    }
    //referencia
    //https://developer.android.com/jetpack/compose/designsystems/material3
    //https://foso.github.io/Jetpack-Compose-Playground/foundation/shape/
    Card(
        modifier = Modifier
            .padding(vertical = 7.dp, horizontal = 12.dp)
            .fillMaxWidth()

            .clickable {
                handleClickCard(movie.id)
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
                //tem que instalar o coil
                //https://coil-kt.github.io/coil/compose/
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(movie.images[0])
                        .crossfade(true).build(),
                    contentDescription = "Image Poster",
                    contentScale = ContentScale.FillHeight

                )
                //default icons
                //Icon(
                //    imageVector = Icons.Default.AccountBox,
                //    contentDescription = "Image icon movie"
                //  )
            }
            Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 15.dp)) {
                Text(text = movie.title, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "Director: ${movie.director}",
                    style = MaterialTheme.typography.labelSmall
                )
                Text(text = "Released: ${movie.year}", style = MaterialTheme.typography.labelSmall)
                AnimatedVisibility(visible = expanded) {
                    Column {
                        //text abaixo e parecido com rico text do flutter
                        Text(text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 13.sp,
                                    color = Color.DarkGray,
                                )
                            ) {
                                append("Plot: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 13.sp,
                                    color = Color.DarkGray,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(movie.plot)
                            }
                        })

                        Divider(modifier = Modifier.padding(vertical = 5.dp))
                        Text(
                            text = "Actors: ${movie.actors}",
                            style = MaterialTheme.typography.labelSmall
                        )
                        Text(
                            text = "Rating: ${movie.rating}",
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
                Icon(
                    modifier = Modifier.clickable {
                        expanded = !expanded
                    },
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = "Icon expanded card"
                )
            }
        }
    }
}


@Preview
@Composable
fun RowMoviesPreview() {
    RowMovies(movie = listMovies[0], handleClickCard = { })
}