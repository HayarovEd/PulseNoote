package com.edurda77.pulsenoote.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.pulsenoote.databinding.ItemSubRvBinding
import com.edurda77.pulsenoote.entity.SubDataInput

class SubAdapter(private val list: List <SubDataInput>): RecyclerView.Adapter<SubHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SubHolder(ItemSubRvBinding.inflate(inflater,parent,false))
    }

    override fun onBindViewHolder(holder: SubHolder, position: Int) {
        val dataList = list[position]
        holder.bind(dataList)
    }

    override fun getItemCount(): Int = list.size
}