package com.gmail.eamosse.imdb.ui.dashboard

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gmail.eamosse.idbdata.data.Category
import com.gmail.eamosse.imdb.databinding.CategoryListItemBinding

class DashboardAdapter(private val items: List<Category>) :
    RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: CategoryListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Category) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(CategoryListItemBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("CALL", "onBindViewHolder")
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            val action = DashboardFragmentDirections.actionNavigationDashboardToSeasonFragment(position.toString(), items[position].name, items[position].id.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }
}
