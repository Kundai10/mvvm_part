package com.example.weeklywins

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weeklywins.model.MyWinsItem

class MyAdapter(
    private val winItems: List<MyWinsItem>

): RecyclerView.Adapter<MyAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val taskTitle: TextView = itemView.findViewById(R.id.text_view_title)
        val taskDate :TextView = itemView.findViewById(R.id.text_view_date)


        fun bind(singleItem: MyWinsItem) {
            taskTitle.text = singleItem.winTitle
            taskDate.text = singleItem.winDayOfWeek

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.single_win_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount() = winItems.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val singleItem = winItems[position]
        holder.bind(singleItem)
    }
}