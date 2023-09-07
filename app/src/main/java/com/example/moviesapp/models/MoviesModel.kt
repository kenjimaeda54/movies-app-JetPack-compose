package com.example.moviesapp.models

data class MoviesModel(
    val id: String,
    val year: String,
    val genre: String,
    val director: String,
    val actors: String,
    val plot: String,
    val poster: String,
    val images: List<String>,
    val rating: String,
    val title: String
)
