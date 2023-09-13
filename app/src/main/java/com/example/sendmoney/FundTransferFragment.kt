package com.example.sendmoney

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.RecentSendItemsAdapter
import com.example.myapplication.adapters.SavedBankAdapter
import com.example.myapplication.model.RecentSendItemModel
import com.example.sendmoney.databinding.FragmentSendMoneyBinding
import com.example.sendmoney.fundtransfer.FundtransferReport
import com.example.sendmoney.model.Saved_bank_model
import com.google.android.material.bottomsheet.BottomSheetDialog


class FundTransferFragment : Fragment() {
    private var _binding: FragmentSendMoneyBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSendMoneyBinding.inflate(inflater, container, false)

        _binding!!.saveAccountBTN.setOnClickListener {
            openBottomSheet()
        }

        _binding!!.btnNext.setOnClickListener {
            startActivity(Intent(activity?.application,FundtransferReport::class.java))
        }

        return binding.root
    }

    private fun openBottomSheet() {
        val dialog = activity?.let { BottomSheetDialog(it) }
        val view = layoutInflater.inflate(R.layout.bottom_sheet_dialoge, null)
        var recyllerviw = view.findViewById<RecyclerView>(R.id.bottomSheetRecyclerView)
        if (dialog != null) {
            dialog.setCancelable(true)
        }
        if (dialog != null) {
            dialog.setContentView(view)
        }
        if (dialog != null) {
            dialog.show()
        }

        recyllerviw.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = SavedBankAdapter(createBankList())
        }


    }

    private fun createBankList(): ArrayList<Saved_bank_model> {
        return arrayListOf<Saved_bank_model>(
            Saved_bank_model(
                "ব্র্যাক ব্যাংক লিমিটেড",
            ),
            Saved_bank_model(
                "ইস্টার্ন ব্যাংক লিমিটেড"
            ),
            Saved_bank_model(
                "ডি সিটি ব্যাংক লিমিটেড"
            ),
            Saved_bank_model(
                "সাউথইস্ট ব্যাংক লিমিটেড",
            ),
            Saved_bank_model(
                "সাউথইস্ট ব্যাংক লিমিটেড"
            ),
            Saved_bank_model(
                "ডি সিটি ব্যাংক লিমিটেড"
            ),
            Saved_bank_model(
                "ব্র্যাক ব্যাংক লিমিটেড",
            ),
            Saved_bank_model(
                "ইস্টার্ন ব্যাংক লিমিটেড"
            ),
            Saved_bank_model(
                "ডি সিটি ব্যাংক লিমিটেড"
            ),
            Saved_bank_model(
                "সাউথইস্ট ব্যাংক লিমিটেড",
            ),
            Saved_bank_model(
                "সাউথইস্ট ব্যাংক লিমিটেড"
            ),
            Saved_bank_model(
                "ডি সিটি ব্যাংক লিমিটেড"
            ),

            )

    }


}