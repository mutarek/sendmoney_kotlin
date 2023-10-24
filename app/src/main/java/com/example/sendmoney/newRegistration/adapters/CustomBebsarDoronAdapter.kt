package com.example.sendmoney.newRegistration.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.sendmoney.R
import com.example.sendmoney.newRegistration.models.BebsarDoronModel
import com.example.sendmoney.newRegistration.models.BusinessTypeModel

class CustomBebsarDoronAdapter(
    private val activity: Activity,
    private val arrayListAddress: ArrayList<BebsarDoronModel>
) : BaseAdapter() {
    private val inflter: LayoutInflater = LayoutInflater.from(activity)
    override fun getCount(): Int {
        return arrayListAddress.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var view = convertView
        if (view == null) {
            view = inflter.inflate(R.layout.my_spinner, null)
        }
        val textView = view?.findViewById<TextView>(R.id.textView)
        if (textView != null) {
            textView.text = arrayListAddress[position].name
        }
        return view
    }
}