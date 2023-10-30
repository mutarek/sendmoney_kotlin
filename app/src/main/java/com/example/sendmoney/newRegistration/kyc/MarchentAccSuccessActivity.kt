package com.example.sendmoney.newRegistration.kyc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivityMarchentAccSuccessBinding

class MarchentAccSuccessActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMarchentAccSuccessBinding
    private lateinit var leftToRightAnim: Animation
    private lateinit var rightToLeft: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarchentAccSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)
        leftToRightAnim = AnimationUtils.loadAnimation(this, R.anim.lefttoright)
        rightToLeft = AnimationUtils.loadAnimation(this, R.anim.righttoleft)
        setToolBar()

        if (binding.moneyTV.text == "ব্যালেন্স দেখুন") {
            binding.moneyIconLeft.visibility = View.VISIBLE
            binding.moneyIconRight.visibility = View.INVISIBLE
        } else {
            binding.moneyIconLeft.visibility = View.INVISIBLE
            binding.moneyIconRight.visibility = View.VISIBLE
        }

        binding.balaceCard.setOnClickListener {
            if (binding.moneyTV.text == "ব্যালেন্স দেখুন") {
                binding.moneyIconLeft.startAnimation(leftToRightAnim)
                object : CountDownTimer(2000, 1000) {

                    override fun onTick(millisUntilFinished: Long) {

                    }

                    override fun onFinish() {
                        binding.moneyTV.text = "5000.00"
                        binding.moneyIconRight.visibility = View.VISIBLE
                        binding.moneyIconLeft.visibility = View.INVISIBLE

                        object : CountDownTimer(1000, 500) {

                            override fun onTick(millisUntilFinished: Long) {

                            }

                            override fun onFinish() {
                                binding.moneyIconRight.startAnimation(rightToLeft)
                                object : CountDownTimer(2000, 1000) {

                                    override fun onTick(millisUntilFinished: Long) {

                                    }

                                    override fun onFinish() {
                                        binding.moneyTV.text = "ব্যালেন্স দেখুন"
                                        binding.moneyIconLeft.visibility = View.VISIBLE
                                        binding.moneyIconRight.visibility = View.INVISIBLE

                                    }
                                }.start()
                            }
                        }.start()
                    }
                }.start()

            }
        }
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