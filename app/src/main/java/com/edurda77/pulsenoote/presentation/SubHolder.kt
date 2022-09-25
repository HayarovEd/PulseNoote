package com.edurda77.pulsenoote.presentation

import androidx.recyclerview.widget.RecyclerView
import com.edurda77.pulsenoote.databinding.ItemSubRvBinding
import com.edurda77.pulsenoote.entity.SubDataInput

class SubHolder(private val binding: ItemSubRvBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(subDataInput: SubDataInput) {
        binding.timeTv.text = subDataInput.time
        binding.highPressureTv.text = subDataInput.highPressure.toString()
        binding.lowPressureTv.text = subDataInput.lowPressure.toString()
        binding.pulseTv.text = subDataInput.pulse.toString()
        setGradient(subDataInput.highPressure, subDataInput.lowPressure)
    }

    private fun setGradient(hp: Int?, lp: Int?) {
        binding.root
    }


}