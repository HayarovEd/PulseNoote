package com.edurda77.pulsenoote.presentation

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.pulsenoote.databinding.ItemRvFirstBinding
import com.edurda77.pulsenoote.entity.DataInput

class DateHolder(private val binding: ItemRvFirstBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind (dataInput: DataInput){
            binding.dateTv.text = dataInput.date
            val layoutManager = LinearLayoutManager(
                binding.subRv.context,
                LinearLayoutManager.VERTICAL,
                false
            )
            val subItemAdapter = SubAdapter(dataInput.records)
            binding.subRv.layoutManager = layoutManager
            binding.subRv.adapter = subItemAdapter
        }
}