package com.dedova.prosoft24.di

import com.dedova.prosoft24.presentation.viewmodel.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<WeatherViewModel> {
        WeatherViewModel(getRemoteDataUseCase = get())
    }
}