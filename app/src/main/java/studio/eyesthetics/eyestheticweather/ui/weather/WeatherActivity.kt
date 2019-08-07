package studio.eyesthetics.eyestheticweather.ui.weather

/**
 * Created by BashkatovSM on 07.08.2019
 */
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_weather.*
import studio.eyesthetics.eyestheticweather.R
import studio.eyesthetics.eyestheticweather.models.SingleWeather
import studio.eyesthetics.eyestheticweather.viewmodel.SingleWeatherViewModel

class WeatherActivity : AppCompatActivity() {

    private lateinit var viewModel: SingleWeatherViewModel
    private lateinit var viewFields: Map<String, TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        initViews(savedInstanceState)
        initViewModel()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(SingleWeatherViewModel::class.java)
        viewModel.getWeatherData().observe(this, Observer { updateUI(it) })
    }

    private fun updateUI(singleWeather: SingleWeather) {
        singleWeather.toMap().also {
            for((k, v) in viewFields) {
                v.text = it[k].toString()
            }
        }
    }

    private fun initViews(savedInstanceState: Bundle?) {
        viewFields = mapOf(
            "degree" to tv_degree,
            "precipitationChance" to tv_chance_of_precipitation,
            "wind" to tv_wind,
            "humidity" to tv_humidity,
            "indexUV" to tv_UV_index,
            "clouds" to tv_clouds
        )
    }
}
