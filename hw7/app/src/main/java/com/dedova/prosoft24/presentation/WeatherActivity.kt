package com.dedova.prosoft24.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dedova.prosoft24.data.model.WeatherResponse
import com.dedova.prosoft24.databinding.ActivityWeatherBinding
import com.dedova.prosoft24.presentation.viewmodel.WeatherViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherBinding
    private val weatherViewModel by viewModel<WeatherViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
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

