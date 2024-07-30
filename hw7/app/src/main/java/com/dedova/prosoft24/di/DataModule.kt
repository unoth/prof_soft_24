package com.dedova.prosoft24.di

import com.dedova.prosoft24.data.repository.WeatherRepositoryImpl
import com.dedova.prosoft24.domain.repository.WeatherRepository
import org.koin.dsl.module

val dataModule = module {

    single<WeatherRepository> {
        WeatherRepositoryImpl(apiService = get())
    }
}