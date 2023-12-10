package com.example.five_spotify

data class music_data(
    val `data`: List<Data>,
    val next: String,
    val total: Int
)