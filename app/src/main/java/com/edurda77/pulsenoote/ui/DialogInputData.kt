package com.edurda77.pulsenoote.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.edurda77.pulsenoote.databinding.DialogViewBinding
import com.edurda77.pulsenoote.entity.DataTransfer
import com.edurda77.pulsenoote.presentation.DialogInputDataViewModel
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.ktx.database
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date
@AndroidEntryPoint
class DialogInputData: DialogFragment() {
    private lateinit var binding: DialogViewBinding
    private val viewModel by viewModels<DialogInputDataViewModel>()

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

            val hp = binding.highPressureEv.text.toString().toInt()
            val lp = binding.lowPressureEv.text.toString().toInt()
            val pl = binding.pulseEv.text.toString().toInt()
            viewModel.addData(hp, lp, pl)

            /*val database = Firebase.database.reference
            val hp = binding.highPressureEv.text.toString().toInt()
            val lp = binding.lowPressureEv.text.toString().toInt()
            val pl = binding.pulseEv.text.toString().toInt()
            if (hp<lp) {
                Toast.makeText(requireContext(), "Верхнее не может быть меньше нижнего давления", Toast.LENGTH_LONG).show()
            } else {
                val newRecord = DataTransfer (hp, lp, pl)
                database.child("record${Date()}").setValue(newRecord)
            }*/


            dismiss()
        }
        binding.cancelBt.setOnClickListener{
            dismiss()
        }
    }



}
