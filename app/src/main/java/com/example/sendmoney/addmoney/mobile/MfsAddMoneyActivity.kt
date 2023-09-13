package com.example.sendmoney.addmoney.mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivityMfsAddMoneyBinding

class MfsAddMoneyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMfsAddMoneyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMfsAddMoneyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentData()

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, MfsAddmoneyReportActivity::class.java))
        }
    }

    private fun getIntentData() {
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")
        binding.cardName.text = name
        binding.cardNumber.text = number
    }
}