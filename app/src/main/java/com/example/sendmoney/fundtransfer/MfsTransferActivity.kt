package com.example.sendmoney.fundtransfer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivityMfsTransferBinding

class MfsTransferActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMfsTransferBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMfsTransferBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, MfsSuccessActivity::class.java))
        }
    }
}