package com.dedova.prosoft24.di

import com.dedova.prosoft24.domain.usecase.GetRemoteDataUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetRemoteDataUseCase> {
        GetRemoteDataUseCase(repository = get())
    }
}