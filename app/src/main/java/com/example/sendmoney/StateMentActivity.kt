package com.example.sendmoney

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.RecentSendItemModel
import com.example.sendmoney.adapters.StatementAdapter
import com.example.sendmoney.model.StatementModel
import java.util.Calendar
import javax.xml.datatype.DatatypeConstants.MONTHS

class StateMentActivity : AppCompatActivity() {
    private lateinit var startDate: TextView
    private lateinit var endDate: TextView
    private lateinit var statementRecyller: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_ment)
        startDate = findViewById(R.id.startDate)
        endDate = findViewById(R.id.endDate)
        statementRecyller = findViewById(R.id.statementRecyclerView)

        startDate.setOnClickListener {
            showStartDatePicker()
        }
        endDate.setOnClickListener {
            showEndDatePicker()
        }
        initRecyllerView()
    }

    private fun initRecyllerView() {
        statementRecyller.apply {
            layoutManager = LinearLayoutManager(this@StateMentActivity)
            adapter = StatementAdapter(createAnimalList())
        }

    }

    private fun createAnimalList(): ArrayList<StatementModel> {
        return arrayListOf<StatementModel>(
            StatementModel(
                "Sultana Fahmina",
                "- ৳500.00",
                "Trans ID : Shaba9303",
                "Charge ৳5.00",
                "09:58am  03/08/23"
            ),
            StatementModel(
                "Mohiuddin Tarek",
                "- ৳500.00",
                "Trans ID : Shaba9303",
                "Charge ৳5.00",
                "09:58am  03/08/23"
            ),

            )
    }

    private fun showStartDatePicker() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(
            this,
            { view, year, monthOfYear, dayOfMonth ->
                startDate.setText("" + dayOfMonth + "-" + monthOfYear + "-" + year)

            },
            year,
            month,
            day
        )

        dpd.show()
    }

    private fun showEndDatePicker() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(
            this,
            { view, year, monthOfYear, dayOfMonth ->
                endDate.setText("" + dayOfMonth + "-" + monthOfYear + "-" + year)

            },
            year,
            month,
            day
        )

        dpd.show()
    }
}