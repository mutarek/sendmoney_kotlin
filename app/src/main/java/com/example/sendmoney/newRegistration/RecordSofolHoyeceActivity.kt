package com.example.sendmoney.newRegistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivityRecordSofolHoyeceBinding

class RecordSofolHoyeceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecordSofolHoyeceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecordSofolHoyeceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolBar()
        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, InformationProcessingActivity::class.java))
        }

    }

    private fun setToolBar() {
        try {
            setSupportActionBar(binding.toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.title = "রেকর্ড সফল হয়েছে"
            binding.toolbar.setNavigationOnClickListener {
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}