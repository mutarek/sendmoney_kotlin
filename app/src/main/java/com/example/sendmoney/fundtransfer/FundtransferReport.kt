package com.example.sendmoney.fundtransfer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivityFundtransferReportBinding

class FundtransferReport : AppCompatActivity() {
    private lateinit var binding: ActivityFundtransferReportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFundtransferReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, FundTransferSuccess::class.java))
        }
    }
}