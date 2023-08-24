package com.example.weather.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.databinding.ListItemBinding
import com.squareup.picasso.Picasso

class WeatherAdapter: ListAdapter<DayItem, WeatherAdapter.Holder>(Comparator()) {

    class Holder(view: View): RecyclerView.ViewHolder(view){
        val binding = ListItemBinding.bind(view)

        fun bind(item: DayItem) = with(binding){
            tvDate.text = item.time
            tvConditoin.text = item.condition
            tvWind.text = item.maxWind
            tvHumiditi.text = item.humidity
            tvTemp.text = item.currentTemp.ifEmpty { "${item.maxTemp}C / ${item.minTemp}C" }
            Picasso.get().load("https:" + item.imageUrl).into(im)
        }
    }

    class Comparator: DiffUtil.ItemCallback<DayItem>(){
        override fun areItemsTheSame(oldItem: DayItem, newItem: DayItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: DayItem, newItem: DayItem): Boolean {
            return newItem == oldItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}