package com.example.sendmoney.newRegistration.kyc

import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivityNidInformationBinding
import com.saadahmedsoft.popupdialog.PopupDialog
import com.saadahmedsoft.popupdialog.Styles
import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener


class NidInformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNidInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNidInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolBar()

        binding.nextStepCard.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_popup_diloge);
            dialog.getWindow()?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(false);
            dialog.getWindow()?.getAttributes()?.windowAnimations = R.style.animation;
            dialog.show();
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