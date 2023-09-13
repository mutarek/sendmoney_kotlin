package com.example.sendmoney.smoney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sendmoney.databinding.ActivityNcscBinding

class SendmoneyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNcscBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNcscBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.takaPathanBTN.setOnClickListener {
            startActivity(Intent(this, SendMoneyPINScreen::class.java))
        }
    }
}