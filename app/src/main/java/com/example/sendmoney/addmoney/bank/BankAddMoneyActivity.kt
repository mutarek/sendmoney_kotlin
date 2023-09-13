package com.example.sendmoney.addmoney.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivityBankAddMoneyBinding

class BankAddMoneyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBankAddMoneyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBankAddMoneyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentData()
        binding.btnNext.setOnClickListener {
            startActivity(Intent(this,BankAddMoneyReportActivity::class.java))
        }
    }

    private fun getIntentData() {
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")
        binding.cardName.text = name
        binding.cardNumber.text = number
    }
}