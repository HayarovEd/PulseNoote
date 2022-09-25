package com.edurda77.pulsenoote.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.edurda77.pulsenoote.databinding.ActivityMainBinding
import com.edurda77.pulsenoote.entity.DataInput
import com.edurda77.pulsenoote.presentation.DialogInputDataViewModel
import com.edurda77.pulsenoote.presentation.MainActivityViewModel
import com.edurda77.pulsenoote.ui.DialogInputData
import com.edurda77.pulsenoote.utils.StateMainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainActivityViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            val dialog = DialogInputData()
            val manager = supportFragmentManager
            dialog.show(manager, "myDialog")
        }
        viewModel.dataForShow.observe(this) {
            println("Размер ${it.size}")
        }
        /*viewModel.showData.observe(this) {
            when (it) {
                is StateMainActivity.Loading -> {

                }
                is StateMainActivity.Failure -> {

                }
                is StateMainActivity.Success -> {
                    println("Размер ${it.data.size}")
                    *//*it.data.forEach {
                        println(it.date)

                        it.records.forEach { subIt->
                            println(subIt.time)
                            println(subIt.highPressure)
                            println(subIt.lowPressure)
                            println(subIt.pulse)
                        }
                    }*//*

                }
                is StateMainActivity.Empty -> {

                }
            }
        }*/

        //val database = Firebase.database.reference

    }

}