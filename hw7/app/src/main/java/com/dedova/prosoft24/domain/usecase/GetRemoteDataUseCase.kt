package com.dedova.prosoft24.domain.usecase

import com.dedova.prosoft24.data.model.WeatherResponse
import com.dedova.prosoft24.domain.repository.WeatherRepository
import retrofit2.Response

class GetRemoteDataUseCase(private val repository: WeatherRepository) {

    suspend fun getRemoteData(): Response<WeatherResponse> {
        return repository.getRemoteData()
    }
}