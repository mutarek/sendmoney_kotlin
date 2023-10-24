package com.example.sendmoney.newRegistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivityMerchantRegistrationBinding
import com.example.sendmoney.newRegistration.adapters.CustomApnarPeshaAdapter
import com.example.sendmoney.newRegistration.adapters.CustomBebsarDoronAdapter
import com.example.sendmoney.newRegistration.adapters.CustomBibaghAdapter
import com.example.sendmoney.newRegistration.adapters.CustomDistrictAdapter
import com.example.sendmoney.newRegistration.adapters.CustomSpinnerAdapter
import com.example.sendmoney.newRegistration.adapters.CustomThanaAdapter
import com.example.sendmoney.newRegistration.models.ApnarPeshaModel
import com.example.sendmoney.newRegistration.models.BebsarDoronModel
import com.example.sendmoney.newRegistration.models.BibaghModel
import com.example.sendmoney.newRegistration.models.BusinessTypeModel
import com.example.sendmoney.newRegistration.models.DistrictModel
import com.example.sendmoney.newRegistration.models.ThanaModel

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

        var adapter = CustomSpinnerAdapter(this@MerchantRegistrationActivity, setData())
        adapter.notifyDataSetChanged()
        binding.businessType.adapter = adapter
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

    private fun setData(): ArrayList<BusinessTypeModel> {
        var model: ArrayList<BusinessTypeModel> = arrayListOf()
        model.add(BusinessTypeModel("সিলেক্ট করুন"))
        model.add(BusinessTypeModel("Bangladesh"))
        model.add(BusinessTypeModel("Dhaka"))
        return model
    }

    private fun setThanaData(): ArrayList<ThanaModel> {
        var model: ArrayList<ThanaModel> = arrayListOf()
        model.add(ThanaModel("সিলেক্ট করুন"))
        model.add(ThanaModel("Laksam"))
        model.add(ThanaModel("Monohorgonj"))
        return model
    }

    private fun thanaSpinner() {
        var adapter = CustomThanaAdapter(this@MerchantRegistrationActivity, setThanaData())
        adapter.notifyDataSetChanged()
        binding.thanaSpinner.adapter = adapter
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


    private fun setDistrictDataData(): ArrayList<DistrictModel> {
        var model: ArrayList<DistrictModel> = arrayListOf()
        model.add(DistrictModel("সিলেক্ট করুন"))
        model.add(DistrictModel("Laksam"))
        model.add(DistrictModel("Monohorgonj"))
        return model
    }

    private fun districtSpinner() {
        var adapter = CustomDistrictAdapter(this@MerchantRegistrationActivity, setDistrictDataData())
        adapter.notifyDataSetChanged()
        binding.districtSpinner.adapter = adapter
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

    private fun setBibaghData(): ArrayList<BibaghModel> {
        var model: ArrayList<BibaghModel> = arrayListOf()
        model.add(BibaghModel("সিলেক্ট করুন"))
        model.add(BibaghModel("Chittagong"))
        model.add(BibaghModel("Dhaka"))
        model.add(BibaghModel("Rajshahi"))
        return model
    }

    private fun bibagSpinner() {
        var adapter = CustomBibaghAdapter(this@MerchantRegistrationActivity, setBibaghData())
        adapter.notifyDataSetChanged()
        binding.bibagSpinner.adapter = adapter

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

    private fun setBebsarDoronData(): ArrayList<BebsarDoronModel> {
        var model: ArrayList<BebsarDoronModel> = arrayListOf()
        model.add(BebsarDoronModel("সিলেক্ট করুন"))
        model.add(BebsarDoronModel("Mudir DOkan"))
        model.add(BebsarDoronModel("Osuder Doakn"))
        model.add(BebsarDoronModel("Birir Dokan"))
        return model
    }

    private fun initBebsarDoronSpinner() {
        var adapter = CustomBebsarDoronAdapter(this@MerchantRegistrationActivity, setBebsarDoronData())
        adapter.notifyDataSetChanged()
        binding.bebsarDoronSpinner.adapter = adapter
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

    private fun setPeshaData(): ArrayList<ApnarPeshaModel> {
        var model: ArrayList<ApnarPeshaModel> = arrayListOf()
        model.add(ApnarPeshaModel("সিলেক্ট করুন"))
        model.add(ApnarPeshaModel("Jobs"))
        model.add(ApnarPeshaModel("Doctor"))
        model.add(ApnarPeshaModel("Engineer"))
        return model
    }

    private fun initBebsaSpinner() {
        var adapter = CustomApnarPeshaAdapter(this@MerchantRegistrationActivity, setPeshaData())
        adapter.notifyDataSetChanged()
        binding.bebsaSpinner.adapter = adapter

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