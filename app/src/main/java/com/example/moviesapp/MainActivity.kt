package com.example.moviesapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviesapp.ui.theme.MoviesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
               MainContent(it)
            }
        }
    }
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(content: @Composable (PaddingValues) -> Unit) {
    MoviesAppTheme {
         Scaffold(topBar = {
             Surface(shadowElevation = 25.dp) {
                 TopAppBar(title = { Text(text = "Movies App") }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                     containerColor =  MaterialTheme.colorScheme.secondaryContainer
                 ))
             }

         }  ) {
            content(it)
         }
    }

}

@Composable
fun MainContent(paddingValues: PaddingValues) {
    //precisa do padding
    Surface(modifier = Modifier.padding(top = paddingValues.calculateTopPadding())) {
        Text(text = "Pedro")
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
     MyApp {
         MainContent(it)
    }
}