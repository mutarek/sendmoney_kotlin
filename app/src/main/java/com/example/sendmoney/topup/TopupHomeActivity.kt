package com.example.sendmoney.topup

import OperatorAdapter
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sendmoney.PermissionTracking
import com.example.sendmoney.R
import com.example.sendmoney.adapters.ContactAdapter
import com.example.sendmoney.databinding.ActivityTopupHomeBinding
import com.example.sendmoney.model.ContactModel
import com.example.sendmoney.model.OperatorModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions


class TopupHomeActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {
    private lateinit var binding: ActivityTopupHomeBinding
    var arrayList: ArrayList<ContactModel> = arrayListOf()
    var rcvAdapter: ContactAdapter = ContactAdapter(arrayList)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopupHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNext.setOnClickListener {
            openBottomSheet()
        }

        if (checkContactPermissions()) {
            binding.apply {
                contactListRecyllerView.apply {
                    layoutManager = LinearLayoutManager(this@TopupHomeActivity)
                    adapter = ContactAdapter(arrayList)

                }
            }
            getContactc()
        }

        binding.goToBulkTopUp.setOnClickListener {
            startActivity(Intent(this@TopupHomeActivity, BulkTopUpActivity::class.java))
        }


    }


    private fun openBottomSheet() {
        val dialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.bottom_sheet_for_operator, null)
        var recyclerView = view.findViewById<RecyclerView>(R.id.operatorRecyllerView)
        var btnNext = view.findViewById<CardView>(R.id.nextBtn)
        if (dialog != null) {
            dialog.setCancelable(true)
        }
        if (dialog != null) {
            dialog.setContentView(view)
        }
        if (dialog != null) {
            dialog.show()
        }

        btnNext.setOnClickListener {
            startActivity(Intent(this, TopupRechargeActivity::class.java))
        }

        recyclerView.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = OperatorAdapter(createOperatorList())
        }

    }

    private fun createOperatorList(): ArrayList<OperatorModel> {
        return arrayListOf<OperatorModel>(
            OperatorModel(
                R.drawable.grammenphone_logo,
                R.color.gp_color
            ),
            OperatorModel(
                R.drawable.my_robi,
                R.color.rb_color
            ),
            OperatorModel(
                R.drawable.my_bl,
                R.color.gp_color
            ),
            OperatorModel(
                R.drawable.my_airtel,
                R.color.rb_color
            ),
            OperatorModel(
                R.drawable.my_teletalk,
                R.color.gp_color
            ),
        )

    }

    private fun getContactc() {
        arrayList.clear()
        val cursor = this.contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI, arrayOf(
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,

                ), null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
        )
        while (cursor!!.moveToNext()) {
            val contactName =
                (cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            val contactNumber =
                (cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
            val contactModel = ContactModel(contactName.toString(), contactNumber.toString())
            arrayList.add(contactModel)
        }
        rcvAdapter.notifyDataSetChanged()
        cursor.close()
    }

    private fun checkContactPermissions(): Boolean {
        if (PermissionTracking.hasCOntactPermissions(this)) {
            return true
        } else if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            EasyPermissions.requestPermissions(
                this,
                "You will need to accept the permission in order to run the application",
                100,
                android.Manifest.permission.READ_CONTACTS,
                android.Manifest.permission.WRITE_CONTACTS,
            )
            return true
        } else {
            return false
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        TODO("Not yet implemented")
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        } else {
            checkContactPermissions()
        }
    }
}