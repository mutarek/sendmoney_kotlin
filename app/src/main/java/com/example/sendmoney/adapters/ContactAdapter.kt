package com.example.sendmoney.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.SavedBankAdapter
import com.example.sendmoney.R
import com.example.sendmoney.model.ContactModel
import com.example.sendmoney.model.Saved_bank_model

class ContactAdapter(private val dataList: ArrayList<ContactModel>) :RecyclerView.Adapter<ContactAdapter.CustomViewHolder>() {
    class CustomViewHolder(itemview: View) :RecyclerView.ViewHolder(itemview) {
//        var name = itemview.findViewById<TextView>(R.id.contactName)
//        var number = itemview.findViewById<TextView>(R.id.contactNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.recharge_history, parent, false)
        return CustomViewHolder(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//        holder.name.text = dataList[position].displayName
//        holder.number.text = dataList[position].number
    }

}