package com.example.moviesapp.widgtes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviesapp.models.MoviesModel

@Composable
fun RowMovies(movie: MoviesModel, handleClickCard: (String) -> Unit) {
    //referencia
    //https://developer.android.com/jetpack/compose/designsystems/material3
    //https://foso.github.io/Jetpack-Compose-Playground/foundation/shape/
    Card(
        modifier = Modifier
            .padding(vertical = 7.dp, horizontal = 12.dp)
            .fillMaxWidth()
            .height(130.dp)
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
            Text(modifier = Modifier.padding(horizontal = 10.dp), text = movie.title)
        }
    }

}
