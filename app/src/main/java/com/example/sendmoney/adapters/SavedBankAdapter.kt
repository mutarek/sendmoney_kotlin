package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.RecentSendItemModel
import com.example.sendmoney.R
import com.example.sendmoney.model.Saved_bank_model

class SavedBankAdapter(private val dataList: ArrayList<Saved_bank_model>) :
    RecyclerView.Adapter<SavedBankAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val name = itemview.findViewById<TextView>(R.id.saveBankNameID)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.saved_bank_layout, parent, false)
        return CustomViewHolder(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.name.text = dataList[position].bankName
    }

}