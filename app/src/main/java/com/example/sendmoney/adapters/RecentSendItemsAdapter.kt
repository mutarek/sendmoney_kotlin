package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.RecentSendItemModel
import com.example.sendmoney.R

class RecentSendItemsAdapter(private val dataList: ArrayList<RecentSendItemModel>) :
    RecyclerView.Adapter<RecentSendItemsAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val name = itemview.findViewById<TextView>(R.id.recentSendName)
        val number = itemview.findViewById<TextView>(R.id.recentSendNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.recent_send_items, parent, false)
        return CustomViewHolder(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.name.text = dataList[position].name
        holder.number.text = dataList[position].number
    }

}