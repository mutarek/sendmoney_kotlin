package com.example.sendmoney.fundtransfer.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.sendmoney.R
import com.example.sendmoney.databinding.FragmentMfsBinding
import com.example.sendmoney.databinding.FragmentSendMoneyBinding
import com.example.sendmoney.fundtransfer.MfsTransferActivity


class MfsFragment : Fragment() {
    private var _binding: FragmentMfsBinding? = null

    private val binding get() = _binding!!
    private lateinit var shebaPayToNagad: LinearLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMfsBinding.inflate(inflater, container, false)

        _binding!!.shebaPaytoMfsID.setOnClickListener {
            startActivity(Intent(activity?.applicationContext, MfsTransferActivity::class.java))
        }

        return binding.root
    }

}