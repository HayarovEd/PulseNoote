package com.edurda77.pulsenoote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.edurda77.pulsenoote.databinding.DialogViewBinding

class DialogInputData: DialogFragment() {
    private lateinit var binding: DialogViewBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogViewBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.okBt.setOnClickListener{
            dismiss()
        }
        binding.cancelBt.setOnClickListener{
            dismiss()
        }
    }


}
