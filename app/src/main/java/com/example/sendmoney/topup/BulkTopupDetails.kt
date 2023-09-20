package com.example.sendmoney.topup

import BulkTopupAdapter
import BulkTopupDetailsAdapter
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sendmoney.R
import com.example.sendmoney.model.BulkTopupModel


class BulkTopupDetails : AppCompatActivity() {
    private lateinit var dataList: ArrayList<BulkTopupModel>
    private lateinit var recyllerview: RecyclerView
    private var totalAmmount: Int = 0
    private lateinit var totalAmmountTV: TextView
    private lateinit var totalTV: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bulk_topup_details)
        dataList = arrayListOf()
        recyllerview = findViewById(R.id.detailsRecyller)
        totalAmmountTV = findViewById(R.id.totalTopUpAmountTV)
        totalTV = findViewById(R.id.totalTV)
        getListOfData()
        initRecyllerview()
        totalTV.text = totalAmmount.toString()
        totalAmmountTV.text = "সর্বমোটঃ  "+ totalAmmount.toString()
    }

    private fun getListOfData() {
        dataList = (intent.getSerializableExtra("key") as ArrayList<BulkTopupModel>?)!!
        for (item in dataList) {
            val singleAmmount = item.amount
            totalAmmount = singleAmmount.toInt() + totalAmmount
        }

    }

    private fun initRecyllerview() {
        recyllerview.apply {
            layoutManager = LinearLayoutManager(this@BulkTopupDetails)
            adapter = BulkTopupDetailsAdapter(dataList)
        }
    }
}