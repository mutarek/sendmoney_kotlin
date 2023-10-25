package com.example.sendmoney.newRegistration.kyc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivityNidVerificationBackPageBinding

class NidVerificationBackPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNidVerificationBackPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNidVerificationBackPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()

        binding.nextStepCard.setOnClickListener {
            startActivity(Intent(this, NidInformationActivity::class.java))
        }

        binding.uploadNIDFont.setOnClickListener {
            resultLauncher.launch("image/*")
        }
    }

    private var resultLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) {
        binding.uploadCard.visibility = View.GONE
        binding.placeHolderCard.visibility = View.VISIBLE
        binding.placement.setImageURI(it)
    }


    private fun setToolbar() {
        try {
            setSupportActionBar(binding.toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.title = "Personal একাউন্ট এক্টিভেশন"
            binding.toolbar.setNavigationOnClickListener {
                onBackPressed();
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}