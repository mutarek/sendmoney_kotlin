package com.example.sendmoney.addmoney.mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapters.AddmoneyCardListAdapter
import com.example.myapplication.adapters.AddmoneyMfsListAdapter
import com.example.sendmoney.R
import com.example.sendmoney.addmoney.bank.BankAddMoneyActivity
import com.example.sendmoney.addmoney.card.CardAddMoneyActivity
import com.example.sendmoney.databinding.ActivityMfsListBinding
import com.example.sendmoney.model.CardListModel

class MfsListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMfsListBinding
    private lateinit var adapter: AddmoneyMfsListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMfsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyllerView()
    }

    private fun setupRecyllerView() {
        binding.mfsListRecyller.layoutManager = LinearLayoutManager(this)
        adapter = AddmoneyMfsListAdapter(createCardList())
        binding.mfsListRecyller.adapter = adapter
        adapter.setOnClickListener(object : AddmoneyMfsListAdapter.OnClickListener {
            override fun onClick(position: Int, todo: CardListModel) {
                val intent = Intent(this@MfsListActivity, MfsAddMoneyActivity::class.java)
                intent.putExtra("name", todo.cardName)
                intent.putExtra("number", todo.cardNumber)
                startActivity(intent)
            }

        })
    }

    private fun createCardList(): ArrayList<CardListModel> {
        return arrayListOf<CardListModel>(
            CardListModel(
                "School Payment", "bKash xxx 261"
            ),
            CardListModel(
                "Bazar Payment", "nagad xxx 261"
            ),
            CardListModel(
                "Movies", "rocket xxx 261"
            ),

            )
    }
}