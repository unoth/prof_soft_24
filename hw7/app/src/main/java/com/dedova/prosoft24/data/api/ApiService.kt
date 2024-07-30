package com.dedova.prosoft24.data.api

import com.dedova.prosoft24.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    suspend fun getWeather(
        @Query(QUERY_PARAM_CITY) cityName: String = CITY_NAME,
        @Query(QUERY_PARAM_API_ID) key: String = API_KEY,
        @Query(QUERY_PARAM_UNITS) units: String = UNIT
    ): Response<WeatherResponse>

    companion object {
        const val QUERY_PARAM_CITY = "q"
        const val QUERY_PARAM_API_ID = "appid"
        const val QUERY_PARAM_UNITS = "units"
        const val CITY_NAME = "saratov"
        const val API_KEY = "60a84e853af11620a1b5050d9de81b3d"
        const val UNIT = "metric"
    }
}