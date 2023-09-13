package com.example.sendmoney.addmoney.card

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivityCardAddMoneyBinding

class CardAddMoneyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCardAddMoneyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardAddMoneyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getIntentData()

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this,CardAddMoneyReportActivity::class.java))
        }
    }

    private fun getIntentData() {
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")
        binding.cardName.text = name
        binding.cardNumber.text = number
    }
}