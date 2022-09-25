package com.edurda77.pulsenoote.presentation

import androidx.recyclerview.widget.RecyclerView
import com.edurda77.pulsenoote.R
import com.edurda77.pulsenoote.databinding.ItemSubRvBinding
import com.edurda77.pulsenoote.entity.SubDataInput

class SubHolder(private val binding: ItemSubRvBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(subDataInput: SubDataInput) {
        binding.timeTv.text = subDataInput.time
        binding.highPressureTv.text = subDataInput.highPressure.toString()
        binding.lowPressureTv.text = subDataInput.lowPressure.toString()
        binding.pulseTv.text = subDataInput.pulse.toString()

        setGradientBackground (subDataInput)
    }
    private fun setGradientBackground (subDataInput: SubDataInput) {
        if (subDataInput.highPressure!! <120 && subDataInput.lowPressure!! <80) {
            binding.root.setBackgroundResource(R.drawable.ad_normal)
        } else if (subDataInput.highPressure in 120..129 && subDataInput.lowPressure!! <80) {
            binding.root.setBackgroundResource(R.drawable.ad_elevated)
        } else if (subDataInput.highPressure in 130..139 || subDataInput.lowPressure!! in 80..89) {
            binding.root.setBackgroundResource(R.drawable.ad_hypertension_1_st)
        } else if (subDataInput.highPressure in 140..180 || subDataInput.lowPressure in 90..120) {
            binding.root.setBackgroundResource(R.drawable.ad_hypertension_2_st)
        } else if (subDataInput.highPressure >180|| subDataInput.lowPressure >120) {
            binding.root.setBackgroundResource(R.drawable.ad_hypertensive_crisis)
        }
    }



}