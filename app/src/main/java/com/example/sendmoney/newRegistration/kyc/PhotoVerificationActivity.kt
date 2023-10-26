package com.example.sendmoney.newRegistration.kyc

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivityPhotoVerificationBinding

class PhotoVerificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhotoVerificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotoVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolBar()
        binding.howToTakePhotos.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.kivave_chobi_tulben_dialoge);
            dialog.getWindow()?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.setCancelable(true)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.getWindow()?.getAttributes()?.windowAnimations = R.style.animation;
//            var button = dialog.findViewById<CardView>(R.id.nextBTN)
//            button.setOnClickListener {
//                startActivity(Intent(this,PhotoVerificationActivity::class.java))
//                dialog.dismiss()
//            }
            dialog.show()
        }

        binding.nextStepCard.setOnClickListener {
            startActivity(Intent(this, MarchentAccSuccessActivity::class.java))
        }
    }

    private fun setToolBar() {
        try {
            setSupportActionBar(binding.toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.title = "Personal একাউন্ট এক্টিভেশন"
            binding.toolbar.setNavigationOnClickListener {
                onBackPressed()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}