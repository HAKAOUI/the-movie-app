package com.gmail.eamosse.imdb.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gmail.eamosse.idbdata.data.Season
import com.gmail.eamosse.imdb.R
import com.gmail.eamosse.imdb.databinding.SeasonListItemBinding

class SeasonAdapter(private val items: List<Season>) :
    RecyclerView.Adapter<SeasonAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: SeasonListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val imageSeason: ImageView = binding.seasonImage

        fun bind(item: Season) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(SeasonListItemBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
        }
        val season: Season = items[position]

        Glide.with(holder.imageSeason)
            .load(season.image)
            .error(R.drawable.ic_baseline_movie_24)
            .into(holder.imageSeason)
    }
}
