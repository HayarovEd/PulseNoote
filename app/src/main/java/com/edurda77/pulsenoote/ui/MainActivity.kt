package com.edurda77.pulsenoote.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.edurda77.pulsenoote.databinding.ActivityMainBinding
import com.edurda77.pulsenoote.presentation.MainActivityViewModel
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


    }

}