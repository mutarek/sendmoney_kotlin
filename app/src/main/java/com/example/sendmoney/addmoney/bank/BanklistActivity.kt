package com.example.sendmoney.addmoney.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapters.AddmoneyCardListAdapter
import com.example.sendmoney.R
import com.example.sendmoney.addmoney.card.CardAddMoneyActivity
import com.example.sendmoney.databinding.ActivityBanklistBinding
import com.example.sendmoney.model.CardListModel

class BanklistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBanklistBinding
    private lateinit var adapter: AddmoneyCardListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBanklistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyllerView()
    }

    private fun setupRecyllerView() {
        binding.bankListRecyller.layoutManager = LinearLayoutManager(this)
        adapter = AddmoneyCardListAdapter(createCardList())
        binding.bankListRecyller.adapter = adapter
        adapter.setOnClickListener(object : AddmoneyCardListAdapter.OnClickListener{
            override fun onClick(position: Int, todo: CardListModel) {
                val intent = Intent(this@BanklistActivity, BankAddMoneyActivity::class.java)
                intent.putExtra("name",todo.cardName)
                intent.putExtra("number",todo.cardNumber)
                startActivity(intent)
            }

        })
    }

    private fun createCardList(): ArrayList<CardListModel> {
        return arrayListOf<CardListModel>(
            CardListModel(
                "ব্র্যাক ব্যাংক লিমিটেড", "0261"
            ),
            CardListModel(
                "ইস্টার্ন ব্যাংক লিমিটেড", "2610"
            ),

            )
    }
}