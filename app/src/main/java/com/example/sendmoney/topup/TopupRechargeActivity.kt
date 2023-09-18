package com.example.sendmoney.topup

import OfferAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.sendmoney.R
import com.example.sendmoney.adapters.FragmentAdapter
import com.example.sendmoney.databinding.ActivityTopupRechargeBinding
import com.example.sendmoney.model.OfferModel
import com.example.sendmoney.model.OperatorModel
import com.google.android.material.tabs.TabLayout

class TopupRechargeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTopupRechargeBinding
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopupRechargeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()

        binding.nextBtn.setOnClickListener {
            startActivity(Intent(this, TopUpSumaryActivity::class.java))
        }

    }

    private fun setupRecyclerView() {
        binding.offerRecyllerview.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = OfferAdapter(createOfferList())
        }
    }

    private fun createOfferList(): ArrayList<OfferModel> {
        return arrayListOf<OfferModel>(
            OfferModel(
                "৳২০"
            ),
            OfferModel(
                "৳৫০"
            ),
            OfferModel(
                "৳৭০"
            ),
            OfferModel(
                "৳১০০"
            ),
            OfferModel(
                "৳২০"
            ),
            OfferModel(
                "৳৫০"
            ),
            OfferModel(
                "৳৭০"
            ),
            OfferModel(
                "৳১০০"
            ),


            )

    }

//    private fun setUpTabLayout() {
//        binding.tabLayout.tabGravity = TabLayout.GRAVITY_FILL
//        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
//        val adapter = FragmentAdapter(this, supportFragmentManager,
//            0)
//        Log.d("test",tabLayout.tabCount.toString())
//        viewPager.adapter = adapter
//        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
//        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                if (tab != null) {
//                    viewPager.currentItem = tab.position
//                }
////                val badge = tab?.orCreateBadge
////                badge?.number = tab?.position!!
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
////                if (tab != null) {
////                    binding.viewPager.currentItem = tab.position
////                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                // Write code to handle tab reselect
//            }
//        })
//
//    }


}