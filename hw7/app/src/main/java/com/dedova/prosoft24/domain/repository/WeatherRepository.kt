package com.dedova.prosoft24.domain.repository

import com.dedova.prosoft24.data.model.WeatherResponse
import retrofit2.Response

interface WeatherRepository {
    suspend fun getRemoteData(): Response<WeatherResponse>
}