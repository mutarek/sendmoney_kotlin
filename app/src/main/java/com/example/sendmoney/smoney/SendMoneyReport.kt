package com.example.sendmoney.smoney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivitySendMoneyReportBinding

class SendMoneyReport : AppCompatActivity() {
    private lateinit var binding: ActivitySendMoneyReportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendMoneyReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this,SendMoneySuccess::class.java))
        }
    }
}