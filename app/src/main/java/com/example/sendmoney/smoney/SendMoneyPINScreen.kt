package com.example.sendmoney.smoney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sendmoney.databinding.ActivitySendMoneyPinscreenBinding

class SendMoneyPINScreen : AppCompatActivity() {
    private lateinit var binding : ActivitySendMoneyPinscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendMoneyPinscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this,SendMoneyReport::class.java))
        }
    }
}