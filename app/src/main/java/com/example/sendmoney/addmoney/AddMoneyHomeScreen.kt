package com.example.sendmoney.addmoney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sendmoney.R
import com.example.sendmoney.addmoney.bank.BanklistActivity
import com.example.sendmoney.addmoney.card.CardListActivity
import com.example.sendmoney.addmoney.mobile.MfsListActivity
import com.example.sendmoney.databinding.ActivityAddMoneyHomeScreenBinding

class AddMoneyHomeScreen : AppCompatActivity() {
    private lateinit var binding : ActivityAddMoneyHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMoneyHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cardToShebaPay.setOnClickListener {
            startActivity(Intent(this,CardListActivity::class.java))
        }

        binding.bankToShebaPay.setOnClickListener {
            startActivity(Intent(this,BanklistActivity::class.java))
        }

        binding.mobileToShebaPay.setOnClickListener {
            startActivity(Intent(this,MfsListActivity::class.java))
        }

    }
}