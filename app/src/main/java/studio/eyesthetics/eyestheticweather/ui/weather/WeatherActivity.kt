package studio.eyesthetics.eyestheticweather.ui.weather

/**
 * Created by BashkatovSM on 07.08.2019
 */
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_weather.*
import studio.eyesthetics.eyestheticweather.R
import studio.eyesthetics.eyestheticweather.adapters.Adapter
import studio.eyesthetics.eyestheticweather.models.SingleWeather
import studio.eyesthetics.eyestheticweather.viewmodel.SingleWeatherViewModel

class WeatherActivity : AppCompatActivity() {

    private lateinit var viewModel: SingleWeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val recyclerView: RecyclerView = rv_weather
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(generateFakeValues())

        //initViews()
        initViewModel()
    }

    private fun generateFakeValues(): MutableList<SingleWeather> {
        val values = mutableListOf<SingleWeather>()
        for(i in 0..10) {
            val sw = SingleWeather("$i", "${30 - i}%", "${12-i}", "${90 - i}%", "3", "${80 - i}%")

            values.add(sw)
        }
        return values
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(SingleWeatherViewModel::class.java)
        //viewModel.getWeatherData().observe(this, Observer { updateUI(it) })
    }

    /*private fun updateUI(singleWeather: SingleWeather) {
        singleWeather.toMap().also {
            for((k, v) in viewFields) {
                Log.d("M_WeatherActivity", "${it[k]}")
                v.text = it[k].toString()
            }
        }
    }*/

    /*private fun initViews() {
        viewFields = mapOf(
            "degree" to tv_degree,
            "precipitationChance" to tv_chance_of_precipitation,
            "wind" to tv_wind,
            "humidity" to tv_humidity,
            "indexUV" to tv_UV_index,
            "clouds" to tv_clouds
        )
    }*/
}
