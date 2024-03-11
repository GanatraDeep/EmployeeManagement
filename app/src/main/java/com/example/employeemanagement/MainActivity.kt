package com.example.employeemanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var totSalary : Int = 0;

        val txtCode : EditText = findViewById(R.id.txtCode)
        val txtName : EditText = findViewById(R.id.txtName)
        val txtDesignation : EditText = findViewById(R.id.txtDesignation)
        val txtDepartment : EditText = findViewById(R.id.txtDepartment)
        val txtDob : EditText = findViewById(R.id.txtDob)
        val txtDoj : EditText = findViewById(R.id.txtDoj)
        val txtSalary : EditText = findViewById(R.id.txtSalary)
        val btnSave : Button = findViewById(R.id.btnSave)
        val btnSearchSales : Button = findViewById(R.id.btnSearchSales)
        val btnReset : Button = findViewById(R.id.btnReset)
        val rv1 : RecyclerView = findViewById(R.id.rv1)
        rv1.layoutManager = LinearLayoutManager(this)

        var emplist = ArrayList<Employee>()
        var saleslist = ArrayList<Employee>()

        var adapter = CustomAdapter(emplist)
        var salesadapter = CustomAdapter(saleslist)
        rv1.adapter = adapter

        btnSave.setOnClickListener(View.OnClickListener {
            var code = Integer.parseInt(txtCode.text.toString())
            var name = txtName.text.toString()
            var designation = txtDesignation.text.toString()
            var department = txtDepartment.text.toString()
            var dob = txtDob.text.toString()
            var doj = txtDoj.text.toString()
            var salary = Integer.parseInt(txtSalary.text.toString())
            totSalary += salary;

            val ts : TextView = findViewById(R.id.totSalary)
            ts.setText("Total Salary = " + totSalary.toString() + " Rs.");

            if(department == "Sales")
            {
                saleslist.add(Employee(code, name, designation, dob, doj, salary, department))
            }

            emplist.add(Employee(code, name, designation, dob, doj, salary, department))
            rv1.adapter = adapter

            adapter.notifyDataSetChanged()
            salesadapter.notifyDataSetChanged()


        })

        btnSearchSales.setOnClickListener(View.OnClickListener {
            rv1.adapter = salesadapter
        })

        btnReset.setOnClickListener(View.OnClickListener {
            rv1.adapter = adapter
        })
    }
}