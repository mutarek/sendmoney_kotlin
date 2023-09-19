package com.example.sendmoney.topup

import BulkTopupAdapter
import BulkTopupDetailsAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sendmoney.R
import com.example.sendmoney.model.BulkTopupModel


class BulkTopupDetails : AppCompatActivity() {
    private lateinit var dataList: ArrayList<BulkTopupModel>
    private lateinit var recyllerview: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bulk_topup_details)
        dataList = arrayListOf()
        recyllerview = findViewById(R.id.detailsRecyller)
        getListOfData()
        initRecyllerview()
    }

    private fun getListOfData() {
        dataList = (intent.getSerializableExtra("key") as ArrayList<BulkTopupModel>?)!!
    }

    private fun initRecyllerview() {
        recyllerview.apply {
            layoutManager = LinearLayoutManager(this@BulkTopupDetails)
            adapter = BulkTopupDetailsAdapter(dataList)
        }
    }
}