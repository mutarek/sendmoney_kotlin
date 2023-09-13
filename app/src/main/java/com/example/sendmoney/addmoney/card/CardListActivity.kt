package com.example.sendmoney.addmoney.card

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapters.AddmoneyCardListAdapter
import com.example.myapplication.adapters.AddmoneyMfsListAdapter
import com.example.myapplication.adapters.RecentSendItemsAdapter
import com.example.myapplication.model.RecentSendItemModel
import com.example.sendmoney.R
import com.example.sendmoney.addmoney.bank.BankAddMoneyActivity
import com.example.sendmoney.databinding.ActivityCardListBinding
import com.example.sendmoney.model.CardListModel

class CardListActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCardListBinding
    private lateinit var adapter : AddmoneyCardListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyllerView()
    }

    private fun setupRecyllerView() {
        binding.cardListRecyller.layoutManager = LinearLayoutManager(this)
        adapter = AddmoneyCardListAdapter(createCardList())
        binding.cardListRecyller.adapter = adapter
        adapter.setOnClickListener(object : AddmoneyCardListAdapter.OnClickListener{
            override fun onClick(position: Int, todo: CardListModel) {
                val intent = Intent(this@CardListActivity, CardAddMoneyActivity::class.java)
                intent.putExtra("name",todo.cardName)
                intent.putExtra("number",todo.cardNumber)
                startActivity(intent)
            }

        })
    }

    private fun createCardList(): ArrayList<CardListModel> {
        return arrayListOf<CardListModel>(
            CardListModel(
                "Home Card", "Visa/Mastercard -xxxx 1234"
            ),
            CardListModel(
                "Study Card", "Visa/Mastercard -xxxx 1234"
            ),
            CardListModel(
                "Travel Card", "Visa/Mastercard -xxxx 1234"
            ),

            )
    }
}