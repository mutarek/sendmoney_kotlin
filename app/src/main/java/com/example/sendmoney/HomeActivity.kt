package com.example.sendmoney

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sendmoney.smoney.SendmoneyActivity
import com.example.myapplication.adapters.RecentSendItemsAdapter
import com.example.myapplication.model.RecentSendItemModel
import com.example.sendmoney.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, SendmoneyActivity::class.java))
        }

        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        binding.recentSendItemsRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = RecentSendItemsAdapter(createAnimalList())
        }
    }

    private fun createAnimalList(): ArrayList<RecentSendItemModel> {
        return arrayListOf<RecentSendItemModel>(
            RecentSendItemModel(
                "Antilope", "01957345431"
            ),
            RecentSendItemModel(
                "Antilope", "01957345431"
            ),
            RecentSendItemModel(
                "Antilope", "01957345431"
            ),

        )
    }


}