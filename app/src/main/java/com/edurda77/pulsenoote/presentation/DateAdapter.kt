package com.edurda77.pulsenoote.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.pulsenoote.databinding.ItemRvFirstBinding
import com.edurda77.pulsenoote.entity.DataInput

class DateAdapter(private val list: List <DataInput>): RecyclerView.Adapter<DateHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DateHolder(ItemRvFirstBinding.inflate(inflater,parent,false))
    }

    override fun onBindViewHolder(holder: DateHolder, position: Int) {
        val dataList = list[position]
        holder.bind(dataList)
    }

    override fun getItemCount(): Int = list.size
}