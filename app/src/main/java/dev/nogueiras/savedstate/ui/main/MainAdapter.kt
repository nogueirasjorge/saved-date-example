package dev.nogueiras.savedstate.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.nogueiras.savedstate.R

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private var data = listOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val numberView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false) as TextView
        return MainViewHolder(number = numberView)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.number.text = data[position]
    }

    fun onNewData(newData: List<String>) {
        this.data = newData
        notifyDataSetChanged()
    }

}
