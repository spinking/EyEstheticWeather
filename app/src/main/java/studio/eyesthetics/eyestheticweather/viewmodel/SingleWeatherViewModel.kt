package studio.eyesthetics.eyestheticweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import studio.eyesthetics.eyestheticweather.models.SingleWeather
import studio.eyesthetics.eyestheticweather.repositories.PreferencesRepository

/**
 * Created by BashkatovSM on 07.08.2019
 */
class SingleWeatherViewModel: ViewModel() {
    private val repository : PreferencesRepository = PreferencesRepository
    private val singleWeatherData = MutableLiveData<SingleWeather>()

    init {
        singleWeatherData.value = repository.getSingleWeather()
    }

    fun getWeatherData(): LiveData<SingleWeather> = singleWeatherData

    fun saveWeatherData(singleWeather: SingleWeather) {
        repository.saveSingleWeather(singleWeather)
        singleWeatherData.value = singleWeather
    }
}