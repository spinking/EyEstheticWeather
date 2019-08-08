package studio.eyesthetics.eyestheticweather.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_view.view.*
import studio.eyesthetics.eyestheticweather.R
import studio.eyesthetics.eyestheticweather.models.SingleWeather
import studio.eyesthetics.eyestheticweather.viewmodel.SingleWeatherViewModel

/**
 * Created by BashkatovSM on 08.08.2019
 */
class Adapter(
    private val values: MutableList<SingleWeather>
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.degree?.text = values[position].degree
        holder.precipitationChance?.text = values[position].clouds
        holder.wind?.text = values[position].wind
        holder.humidity?.text = values[position].humidity
        holder.indexUV?.text = values[position].indexUV
        holder.clouds?.text = values[position].clouds
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var degree: TextView? = null
        var precipitationChance: TextView? = null
        var wind: TextView? = null
        var humidity: TextView? = null
        var indexUV: TextView? = null
        var clouds: TextView? = null

        init {
            degree = itemView.tv_degree
            precipitationChance = itemView.tv_chance_of_precipitation
            wind = itemView.tv_wind
            humidity = itemView.tv_humidity
            indexUV = itemView.tv_UV_index
            clouds = itemView.tv_clouds
        }
    }

}