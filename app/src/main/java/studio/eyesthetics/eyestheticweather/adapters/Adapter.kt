package studio.eyesthetics.eyestheticweather.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_view.view.*
import studio.eyesthetics.eyestheticweather.R
import studio.eyesthetics.eyestheticweather.models.SingleWeather

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
        val singleWeather = values[position]
        holder.bind(singleWeather)

        holder.itemView.setOnClickListener{
            for (i in 0 until values.size) {
                if(i != position) {
                    values[i].expanded = false
                    notifyItemChanged(i)
                }
            }
            val expanded = singleWeather.isExpanded()

            singleWeather.setIsExpanded(!expanded)
            notifyItemChanged(position)
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var degree: TextView? = null
        var precipitationChance: TextView? = null
        var wind: TextView? = null
        var humidity: TextView? = null
        var indexUV: TextView? = null
        var clouds: TextView? = null
        var subItems: View? = null

        init {
            degree = itemView.tv_degree
            precipitationChance = itemView.tv_chance_of_precipitation
            wind = itemView.tv_wind
            humidity = itemView.tv_humidity
            indexUV = itemView.tv_UV_index
            clouds = itemView.tv_clouds
            subItems = itemView.sub_items
        }

        fun bind(singleWeather: SingleWeather) {
            val expanded: Boolean = singleWeather.isExpanded()

            subItems?.visibility = (if(expanded) View.VISIBLE else View.GONE)

            degree?.text = singleWeather.degree
            precipitationChance?.text = singleWeather.precipitationChance
            wind?.text = singleWeather.wind
            humidity?.text = singleWeather.humidity
            indexUV?.text = singleWeather.indexUV
            clouds?.text = singleWeather.clouds
        }
    }

}