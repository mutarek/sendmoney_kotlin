package com.example.sendmoney.newRegistration.kyc

import ShebaPackageAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivityShebaUserPackageBinding
import com.example.sendmoney.newRegistration.kyc.models.ShebaPackageModel

class ShebaUserPackageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShebaUserPackageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShebaUserPackageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        initRecyllerView()

        binding.nextStepCard.setOnClickListener {
            startActivity(Intent(this, NidVerificationActivity::class.java))
        }

        binding.skipBtn.setOnClickListener {
            startActivity(Intent(this, NidVerificationActivity::class.java))
        }
    }

    private fun initRecyllerView() {
        binding.packageRecyllerView.apply {
            layoutManager = LinearLayoutManager(this@ShebaUserPackageActivity)
            adapter = ShebaPackageAdapter(setDummyData())
        }
    }

    private fun setDummyData(): ArrayList<ShebaPackageModel> {
        var list = ArrayList<ShebaPackageModel>()
        list.add(
            ShebaPackageModel(
                "Personal",
                "- MDR: Bank 1.29%",
                "- মাসিক লিমিট: ৳১০০,০০০",
                "- ক্যাশ আউট ফি: 2%"
            )
        )
        list.add(
            ShebaPackageModel(
                "Retail A",
                "- MDR: Bank 1.29%",
                "- মাসিক লিমিট: ৳১০০,০০০",
                "- ক্যাশ আউট ফি: 2%"
            )
        )
        list.add(
            ShebaPackageModel(
                "Retail B",
                "- MDR: Bank 1.29%",
                "- মাসিক লিমিট: ৳১০০,০০০",
                "- ক্যাশ আউট ফি: 2%"
            )
        )
        list.add(
            ShebaPackageModel(
                "Retail C",
                "- MDR: Bank 1.29%",
                "- মাসিক লিমিট: ৳১০০,০০০",
                "- ক্যাশ আউট ফি: 2%"
            )
        )
        list.add(
            ShebaPackageModel(
                "Retail D",
                "- MDR: Bank 1.29%",
                "- মাসিক লিমিট: ৳১০০,০০০",
                "- ক্যাশ আউট ফি: 2%"
            )
        )
        return list
    }

    private fun setToolbar() {
        try {
            setSupportActionBar(binding.toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.title = "পরিকল্পনা বাছাই"
            binding.toolbar.setNavigationOnClickListener {
                onBackPressed();
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}