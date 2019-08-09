package studio.eyesthetics.eyestheticweather.repositories

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import studio.eyesthetics.eyestheticweather.App
import studio.eyesthetics.eyestheticweather.models.SingleWeather

/**
 * Created by BashkatovSM on 07.08.2019
 */
object PreferencesRepository {

    private const val DEGREE = "DEGREE"
    private const val PRECIPITATION_CHANCE = "PRECIPITATION_CHANCE"
    private const val WIND = "WIND"
    private const val HUMIDITY = "HUMIDITY"
    private const val INDEX_UV = "INDEX_UV"
    private const val CLOUDS = "CLOUDS"
    private const val EXPANDED = "EXPANDED"

    private val prefs: SharedPreferences by lazy {
        val ctx = App.applicationContext()
        PreferenceManager.getDefaultSharedPreferences(ctx)
     }

    fun getSingleWeather(): SingleWeather = SingleWeather(
        prefs.getString(DEGREE, "")!!,
        prefs.getString(PRECIPITATION_CHANCE, "")!!,
        prefs.getString(WIND, "")!!,
        prefs.getString(HUMIDITY, "")!!,
        prefs.getString(INDEX_UV, "")!!,
        prefs.getString(CLOUDS, "")!!,
        prefs.getBoolean(EXPANDED, false)
    )

    fun saveSingleWeather(singleWeather: SingleWeather) {
        with(singleWeather) {
            putValue(DEGREE to degree)
            putValue(PRECIPITATION_CHANCE to precipitationChance)
            putValue(WIND to wind)
            putValue(HUMIDITY to humidity)
            putValue(INDEX_UV to indexUV)
            putValue(CLOUDS to clouds)
            putValue(EXPANDED to expanded)
        }
    }

    private fun putValue(pair: Pair<String, Any>) = with(prefs.edit()) {

        val key = pair.first

        when (val value = pair.second) {
            is String -> putString(key, value)
            is Int -> putInt(key, value)
            is Boolean -> putBoolean(key, value)
            is Long -> putLong(key, value)
            is Float -> putFloat(key, value)
            else -> error("Only primitives types can be stored in Shared Preferences")
        }
        apply()
    }
}