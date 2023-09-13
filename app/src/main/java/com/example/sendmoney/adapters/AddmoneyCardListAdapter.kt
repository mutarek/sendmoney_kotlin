package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.RecentSendItemModel
import com.example.sendmoney.R
import com.example.sendmoney.model.CardListModel
import com.example.sendmoney.model.Saved_bank_model

class AddmoneyCardListAdapter(private val dataList: ArrayList<CardListModel>) :
    RecyclerView.Adapter<AddmoneyCardListAdapter.CustomViewHolder>() {

    private var mOnClickListener: OnClickListener? = null


    class CustomViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val name = itemview.findViewById<TextView>(R.id.cardName)
        val number = itemview.findViewById<TextView>(R.id.cardNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.custom_card_list, parent, false)
        return CustomViewHolder(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.name.text = dataList[position].cardName
        holder.number.text = dataList[position].cardNumber
        holder.itemView.setOnClickListener {
            if (mOnClickListener != null) {
                mOnClickListener!!.onClick(position, dataList[position])
            }
        }
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.mOnClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, todo: CardListModel)
    }

}