package com.dedova.prosoft24.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dedova.prosoft24.data.api.ApiService
import com.dedova.prosoft24.data.model.WeatherResponse
import com.dedova.prosoft24.databinding.ActivityWeatherBinding
import com.dedova.prosoft24.domain.repository.WeatherRepository
import com.dedova.prosoft24.presentation.viewmodel.WeatherViewModel
import com.dedova.prosoft24.presentation.viewmodel.WeatherViewModelFactory

class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherBinding
    private lateinit var weatherViewModel: WeatherViewModel
    private lateinit var weatherViewModelFactory: WeatherViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        weatherViewModelFactory =
            WeatherViewModelFactory(WeatherRepository(ApiService.getInstance()))
        weatherViewModel =
            ViewModelProvider(this, weatherViewModelFactory)[WeatherViewModel::class.java]
        weatherViewModel.loadWeather()
        setUpObservers()
    }

    private fun setUpObservers() {
        weatherViewModel.weatherLiveData.observe(this) {
            setResult(it)
        }

        weatherViewModel.error.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        weatherViewModel.processing.observe(this) {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    private fun setResult(weatherResponse: WeatherResponse) {
        weatherResponse.apply {
            binding.apply {
                textViewNameCity.text = name
                textViewTemp.text = String.format("%s°C", main.temp)
                textViewFeelsLike.text =
                    String.format("Feels like %s°C, %s", main.feels_like, weather[0].description)
                textViewInfo.text =
                    String.format(
                        "min: %s°C, max: %s°C\n" +
                                "pressure: %s hPa\n" +
                                "humidity: %s %\n" +
                                "visibility: %skm",
                        main.temp_min,
                        main.temp_min,
                        main.pressure,
                        main.humidity,
                        visibility
                    )
                textViewWind.text =
                    String.format(
                        "wind speed: %s m/s\n" +
                                "gust: %s m/s\n" +
                                "direction: %s",
                        wind.speed,
                        wind.gust,
                        wind.deg
                    )
            }
        }
    }
}

