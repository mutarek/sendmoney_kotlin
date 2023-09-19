package com.example.sendmoney.topup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.view.View
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivityTopUpSumaryBinding

class TopUpSumaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTopUpSumaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopUpSumaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvSwitchPay.visibility = View.INVISIBLE
        binding.tvSwitchCredit.visibility = View.VISIBLE

        binding.nextBtn.setOnClickListener {
            startActivity(Intent(this, BulkTopUpActivity::class.java))
        }

        if(binding.switchOnOff.isChecked){
            binding.tvSwitchCredit.visibility = View.INVISIBLE
        }

//        if(binding.switchOnOff.isChecked){
//            binding.tvSwitchPay.visibility = View.INVISIBLE
//            binding.tvSwitchCredit.visibility = View.VISIBLE
//        }
//        else{
//            binding.tvSwitchPay.visibility = View.VISIBLE
//            binding.tvSwitchCredit.visibility = View.INVISIBLE
//        }

    }
}