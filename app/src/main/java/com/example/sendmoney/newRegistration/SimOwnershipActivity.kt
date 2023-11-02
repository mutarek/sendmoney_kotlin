package com.example.sendmoney.newRegistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivitySimOwnershipBinding

class SimOwnershipActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimOwnershipBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimOwnershipBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolBar()
        binding.dokaneChobiUpload.setOnClickListener {
            galleryLauncher.launch("image/*")
        }

        binding.retakePhoto.setOnClickListener {
            binding.dokaneChobiUpload.visibility = View.VISIBLE
            binding.dokaneChobiLayout.visibility = View.GONE
            binding.dokaneChobiPlacement.setImageURI(null)
        }

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, RecordSofolHoyeceActivity::class.java))
        }
    }

    val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) {
        val galleryUri = it
        try {
            binding.dokaneChobiUpload.visibility = View.GONE
            binding.dokaneChobiLayout.visibility = View.VISIBLE
            binding.dokaneChobiPlacement.setImageURI(galleryUri)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun setToolBar() {
        try {
            setSupportActionBar(binding.toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.title = "সিমের মালিকানা প্রমাণ"
            binding.toolbar.setNavigationOnClickListener {
                onBackPressed()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}