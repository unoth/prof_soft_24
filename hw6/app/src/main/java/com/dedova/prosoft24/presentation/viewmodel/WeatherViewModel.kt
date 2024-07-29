package com.dedova.prosoft24.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dedova.prosoft24.data.model.WeatherResponse
import com.dedova.prosoft24.data.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {
    val weatherLiveData = MutableLiveData<WeatherResponse>()
    val error = MutableLiveData<String>()
    val processing = MutableLiveData<Boolean>()

    fun loadWeather() {
        viewModelScope.launch(Dispatchers.IO)
        {
            try {
                processing.postValue(true)
                val response = repository.getRemoteData()
                processing.postValue(false)
                if (!response.isSuccessful) {
                    error.postValue("Failed to load data: ${response.code()}")
                    return@launch
                }
                response.body()?.let {
                    weatherLiveData.postValue(it)
                }
            } catch (e: Exception) {
                error.postValue("Server is not available. \nPlease try again later")
                e.printStackTrace()
                Log.d("Load_Test", "Error: $e")
                processing.postValue(false)
            }
        }
    }
}