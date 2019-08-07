package studio.eyesthetics.eyestheticweather.models

/**
 * Created by BashkatovSM on 07.08.2019
 */
data class SingleWeather(
    val degree: String = "${"\u00b0"}25",
    val precipitationChance: String = "30%",
    val wind: String = "7ms",
    val humidity: String = "86%",
    val indexUV: String = "3",
    val clouds: String = "45%"
) {
    fun toMap() : Map<String, Any> = mapOf(
        "degree" to degree,
        "precipitationChance" to precipitationChance,
        "wind" to wind,
        "humidity" to humidity,
        "indexUV" to indexUV,
        "clouds" to clouds
    )
}