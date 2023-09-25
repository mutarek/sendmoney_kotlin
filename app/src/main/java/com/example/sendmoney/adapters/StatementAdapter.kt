package com.example.sendmoney.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.sendmoney.R
import com.example.sendmoney.model.OfferModel
import com.example.sendmoney.model.OperatorModel
import com.example.sendmoney.model.StatementModel

class StatementAdapter(private val dataList: ArrayList<StatementModel>) :
    RecyclerView.Adapter<StatementAdapter.CustomViewHolder>() {

    private var mOnClickListener: OnClickListener? = null
    private var mSelectedItem = -1


    class CustomViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var name = itemview.findViewById<TextView>(R.id.nameTV)
        var trans = itemview.findViewById<TextView>(R.id.transcationTV)
        var dateTime = itemview.findViewById<TextView>(R.id.dateTimeTV)
        var charge = itemview.findViewById<TextView>(R.id.chargeTV)
        val ammount = itemview.findViewById<TextView>(R.id.amountTV)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType
        : Int
    ): CustomViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.statement_layout, parent, false)
        return CustomViewHolder(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.ammount.text = dataList[position].amount
        holder.name.text = dataList[position].name
        holder.trans.text = dataList[position].transtion
        holder.dateTime.text = dataList[position].dateTime
        holder.charge.text = dataList[position].charge
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.mOnClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, todo: OperatorModel)
    }

}