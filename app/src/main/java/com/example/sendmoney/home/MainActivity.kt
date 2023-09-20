package com.example.sendmoney.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.sendmoney.R
import com.example.sendmoney.home.fragments.NavigationHomeFragment
import com.example.sendmoney.home.fragments.NavigationMoreFragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.isItemActiveIndicatorEnabled =false
        loadFragment(NavigationHomeFragment())
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    loadFragment(NavigationHomeFragment())
                }

                R.id.navigation_report -> {
                    loadFragment(NavigationMoreFragment())

                }

                R.id.navigation_more -> {
                    loadFragment(NavigationMoreFragment())

                }
            }
            true

        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}