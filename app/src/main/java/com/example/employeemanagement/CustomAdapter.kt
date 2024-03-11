package com.example.employeemanagement

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(var emplist:List<Employee>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(var ItemView:View):RecyclerView.ViewHolder(ItemView){
        val txt1:TextView = ItemView.findViewById(R.id.txt1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var temp = emplist[position]
        holder.txt1.text=temp.toString()
    }

    override fun getItemCount(): Int {
        return emplist.size
    }
}