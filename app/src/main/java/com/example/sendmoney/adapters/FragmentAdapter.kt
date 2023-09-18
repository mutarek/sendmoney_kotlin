package com.example.sendmoney.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.sendmoney.topup.fragments.AmmountFragment

class FragmentAdapter(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int
) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                AmmountFragment()
            }

//            1 -> {
//                AmmountFragment()
//            }
//
//            2 -> {
//                AmmountFragment()
//            }
//
//            3 -> {
//                AmmountFragment()
//            }
//
//            4 -> {
//                AmmountFragment()
//            }
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}