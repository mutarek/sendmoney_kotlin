package com.example.sendmoney.fundtransfer

import ViewPagerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.example.sendmoney.fundtransfer.fragments.FundTransferFragment
import com.example.sendmoney.databinding.ActivityFundTransfer2Binding
import com.example.sendmoney.fundtransfer.fragments.MfsFragment
import com.google.android.material.tabs.TabLayout

class FundTransferActivity : AppCompatActivity() {
    private lateinit var pager: ViewPager
    private lateinit var tab: TabLayout
    private lateinit var bar: Toolbar
    private lateinit var binding: ActivityFundTransfer2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFundTransfer2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        pager = binding.viewPager
        tab = binding.tabs
        bar = binding.toolbar

        setSupportActionBar(bar)

        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(FundTransferFragment(), "সেবা পে টু ব্যাংক")
        adapter.addFragment(MfsFragment(), "সেবা পে টু MFS")
        adapter.addFragment(FundTransferFragment(), "")

        pager.adapter = adapter

        // bind the viewPager with the TabLayout.
        tab.setupWithViewPager(pager)
    }
}