package com.dedova.prosoft24.domain.repository

import com.dedova.prosoft24.data.api.ApiService

class WeatherRepository(private val apiService: ApiService) {

    suspend fun getRemoteData() = apiService.getWeather()
}