package com.dedova.prosoft24.data.api

import android.annotation.SuppressLint
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@SuppressLint("CheckResult")
object ApiFactory {
    private const val TIMEOUT_IN_SECONDS = 30L
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"


    val retrofit: Retrofit by lazy {
        val moshiBuilder = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        val okHttpClient = OkHttpClient.Builder().apply {
            connectTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            readTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            writeTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        }.build()

        val retrofit = Retrofit.Builder().apply {
            baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshiBuilder))
                .client(okHttpClient)
                .build()

        }.build()
        retrofit
    }
}