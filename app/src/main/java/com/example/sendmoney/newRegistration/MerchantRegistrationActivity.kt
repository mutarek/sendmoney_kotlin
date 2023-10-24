package com.example.sendmoney.newRegistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivityMerchantRegistrationBinding

class MerchantRegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMerchantRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMerchantRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBebsaSpinner()
        initBebsarDoronSpinner()
        bibagSpinner()
        districtSpinner()
        thanaSpinner()
        initBusinessTypeSpinner()

    }

    private fun initBusinessTypeSpinner() {
        val typeAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.businessType, android.R.layout.simple_spinner_item
        )

        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.businessType.adapter = typeAdapter

        binding.businessType.setOnItemSelectedListener(object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                //simType = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })
    }

    private fun thanaSpinner() {
        val typeAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.thana, android.R.layout.simple_spinner_item
        )

        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.thanaSpinner.adapter = typeAdapter

        binding.thanaSpinner.setOnItemSelectedListener(object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                //simType = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })
    }


    private fun districtSpinner() {
        val typeAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.district, android.R.layout.simple_spinner_item
        )

        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.districtSpinner.adapter = typeAdapter

        binding.districtSpinner.setOnItemSelectedListener(object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                //simType = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })
    }

    private fun bibagSpinner() {
        val typeAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.bibagh, android.R.layout.simple_spinner_item
        )

        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.bibagSpinner.adapter = typeAdapter

        binding.bibagSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                //simType = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })
    }

    private fun initBebsarDoronSpinner() {
        val typeAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.bebsarDoron, android.R.layout.simple_spinner_item
        )

        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.bebsarDoronSpinner.adapter = typeAdapter

        binding.bebsarDoronSpinner.setOnItemSelectedListener(object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                //simType = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })
    }

    private fun initBebsaSpinner() {
        val typeAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.bebsa, android.R.layout.simple_spinner_item
        )

        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.bebsaSpinner.adapter = typeAdapter

        binding.bebsaSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                //simType = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })
    }
}