package studio.eyesthetics.eyestheticweather.models

/**
 * Created by BashkatovSM on 07.08.2019
 */
data class SingleWeather(
    var degree: String,
    var precipitationChance: String,
    var wind: String,
    var humidity: String,
    var indexUV: String,
    var clouds: String,
    var expanded: Boolean
) {

    /*init {
        degree = "25C${"\u00b0"}"
        precipitationChance = "30%"
        wind = "7ms"
        humidity = "86%"
        indexUV = "3"
        clouds = "45%"
    }*/

    fun toMap() : Map<String, Any> = mapOf(
        "degree" to degree,
        "precipitationChance" to precipitationChance,
        "wind" to wind,
        "humidity" to humidity,
        "indexUV" to indexUV,
        "clouds" to clouds
    )

    fun setIsExpanded(expanded: Boolean) {
        this.expanded = expanded
    }

    fun isExpanded(): Boolean {
        return expanded
    }
}