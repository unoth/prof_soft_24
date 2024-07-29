package com.dedova.prosoft24.data.model

data class WeatherResponse(
    val base: String,
    val id: Int,
    val main: Main,
    val name: String,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)