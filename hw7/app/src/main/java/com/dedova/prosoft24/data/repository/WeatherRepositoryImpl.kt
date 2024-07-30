package com.dedova.prosoft24.data.repository

import com.dedova.prosoft24.data.api.ApiService
import com.dedova.prosoft24.data.model.WeatherResponse
import com.dedova.prosoft24.domain.repository.WeatherRepository
import retrofit2.Response

class WeatherRepositoryImpl(private val apiService: ApiService) : WeatherRepository {
    override suspend fun getRemoteData(): Response<WeatherResponse> {
        return apiService.getWeather()
    }
}