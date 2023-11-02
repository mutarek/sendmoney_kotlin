package com.example.sendmoney.newRegistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivityInformationProcessingBinding

class InformationProcessingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationProcessingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationProcessingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setToolBar() {
        try {
            setSupportActionBar(binding.toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.title = "..."
            binding.toolbar.setNavigationOnClickListener {
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}