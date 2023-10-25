package com.example.sendmoney.newRegistration.kyc

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivityNidVerificationBinding
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date

class NidVerificationActivity : AppCompatActivity() {
    private val PERMISSION_CODE = 1000
    private val IMAGE_CAPTURE_CODE = 1001
    var vFilename: String = ""
    private lateinit var binding: ActivityNidVerificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNidVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()

        binding.nextStepCard.setOnClickListener {
            startActivity(Intent(this, NidVerificationBackPageActivity::class.java))
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