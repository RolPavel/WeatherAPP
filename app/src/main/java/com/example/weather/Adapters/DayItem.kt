package com.example.weather.Adapters

data class DayItem(
    val city: String,
    val time: String,
    val condition: String,
    val currentTemp: String,
    val maxTemp: String,
    val minTemp: String,
    val imageUrl: String,
    val maxWind: String,
    val humidity: String,

)
