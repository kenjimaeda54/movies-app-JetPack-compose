package com.example.moviesapp.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

//preview referencia
//https://developer.android.com/jetpack/compose/tooling/previews

//referencia
//https://www.jetpackcompose.net/textstyle-in-jetpack-compose
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, movie: String?) {
    if (movie != null) {
        Scaffold(topBar = {
            TopAppBar(title = {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(modifier = Modifier
                        .size(15.dp)
                        .clickable {
                            navController.popBackStack()
                        },
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back to pop")
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
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = movie, style = androidx.compose.ui.text.TextStyle(
                            fontSize = 20.sp
                        )
                    )
                }
            }
        }
    }
}

