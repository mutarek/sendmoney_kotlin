package com.example.sendmoney.newRegistration.kyc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivityMarchentAccSuccessBinding

class MarchentAccSuccessActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMarchentAccSuccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarchentAccSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolBar()
    }

    private fun setToolBar() {
        try {
            setSupportActionBar(binding.toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.title = "একাউন্ট এক্টিভেশন সফল হয়েছে "
            binding.toolbar.setNavigationOnClickListener {
                onBackPressed()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}