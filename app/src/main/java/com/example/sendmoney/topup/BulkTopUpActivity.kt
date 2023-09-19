package com.example.sendmoney.topup

import BulkTopupAdapter
import OperatorAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sendmoney.R
import com.example.sendmoney.model.BulkTopupModel
import com.example.sendmoney.model.OperatorModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class BulkTopUpActivity : AppCompatActivity() {
    private lateinit var opeator: TextView
    private lateinit var opeatorIcon: ImageView
    private lateinit var addToTopUpList: ImageView
    private lateinit var adapter: OperatorAdapter
    private lateinit var bulkAdapter: BulkTopupAdapter
    private lateinit var dataList: ArrayList<BulkTopupModel>
    private lateinit var number: TextInputEditText
    private lateinit var operatorLayout: LinearLayout
    private lateinit var amount: TextInputEditText
    private lateinit var recyclerView: RecyclerView
    private lateinit var nextBTN: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bulk_top_up)
        opeator = findViewById(R.id.selectOperator)
        operatorLayout = findViewById(R.id.operator)
        addToTopUpList = findViewById(R.id.addToList)
        number = findViewById(R.id.typeNumberET)
        amount = findViewById(R.id.typeAmount)
        recyclerView = findViewById(R.id.bulkRecyller)
        nextBTN = findViewById(R.id.nextBtn)
        opeatorIcon = findViewById(R.id.operatorIcon)
        dataList = arrayListOf()
        opeator.setOnClickListener {
            openBottomSheet()
        }

        nextBTN.setOnClickListener {
            val intent = Intent(this, BulkTopupDetails::class.java)
            intent.putExtra("key", dataList)
            startActivity(intent)
        }

//        operatorLayout.setOnClickListener {
//            openBottomSheet()
//        }
        addToTopUpList.setOnClickListener {
            val model = BulkTopupModel(
                number.text.toString(),
                opeator.text.toString(),
                amount.text.toString(),
                R.drawable.gp_icon
            )
            dataList.add(0, model)
            opeator.setText("অপারেটর")
            number.text?.clear()
            amount.text?.clear()
            initRecyllerView()
            bulkAdapter.notifyDataSetChanged()
        }
        if (dataList.isEmpty()) {
            Toast.makeText(this, "No Contact Found", Toast.LENGTH_SHORT).show()
        } else {
            initRecyllerView()
        }
    }

    private fun initRecyllerView() {
        recyclerView.layoutManager = LinearLayoutManager(this@BulkTopUpActivity)
        bulkAdapter = BulkTopupAdapter(dataList)
        recyclerView.adapter = bulkAdapter
        bulkAdapter.setOnClickListener(object : BulkTopupAdapter.OnClickListener {
            override fun onClick(position: Int, todo: BulkTopupModel) {
                dataList.removeAt(position)
                bulkAdapter.notifyDataSetChanged()
            }

        })
    }

    private fun openBottomSheet() {
        val dialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.bottom_sheet_for_operator, null)
        var recyclerView = view.findViewById<RecyclerView>(R.id.operatorRecyllerView)
        var btnNext = view.findViewById<CardView>(R.id.nextBtn)
        dialog.setCancelable(true)
        dialog.setContentView(view)
        dialog.show()
        btnNext.setOnClickListener {
            if (dialog.isShowing()) {
                dialog.dismiss();
            } else {
                dialog.show();
            }
        }

        recyclerView.layoutManager = GridLayoutManager(this, 3)
        adapter = OperatorAdapter(createOperatorList())
        recyclerView.adapter = adapter
        adapter.setOnClickListener(object : OperatorAdapter.OnClickListener {
            override fun onClick(position: Int, todo: OperatorModel) {
                if (position == 0) {
                    opeator.setText("গ্রামীনফোন")
                    opeatorIcon.setImageDrawable(resources.getDrawable(R.drawable.gp_icon))
                }
                if (position == 1) {
                    opeator.setText("রবি ")
                    opeatorIcon.setImageDrawable(resources.getDrawable(R.drawable.rb_icon))
                }
                if (position == 2) {
                    opeator.setText("বাংলালিংক ")
                    opeatorIcon.setImageDrawable(resources.getDrawable(R.drawable.bl_icon))
                }
                if (position == 3) {
                    opeator.setText("এয়ারটেল ")
                    opeatorIcon.setImageDrawable(resources.getDrawable(R.drawable.airtel_icon))
                }
                if (position == 4) {
                    opeator.setText("টেলিটক ")
                    opeatorIcon.setImageDrawable(resources.getDrawable(R.drawable.gp_icon))
                }
            }

        })

    }

    private fun createOperatorList(): ArrayList<OperatorModel> {
        return arrayListOf<OperatorModel>(
            OperatorModel(
                R.drawable.grammenphone_logo, R.color.gp_color
            ),
            OperatorModel(
                R.drawable.my_robi, R.color.rb_color
            ),
            OperatorModel(
                R.drawable.my_bl, R.color.gp_color
            ),
            OperatorModel(
                R.drawable.my_airtel, R.color.rb_color
            ),
            OperatorModel(
                R.drawable.my_teletalk, R.color.gp_color
            ),
        )

    }
}