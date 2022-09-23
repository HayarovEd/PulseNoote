package com.edurda77.pulsenoote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.edurda77.pulsenoote.databinding.ActivityMainBinding
import com.edurda77.pulsenoote.entity.DataInput
import com.edurda77.pulsenoote.entity.DataTransfer
import com.edurda77.pulsenoote.entity.SubDataInput
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import java.util.HashSet

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val dataForShow = mutableListOf<DataInput>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            val dialog = DialogInputData()
            val manager = supportFragmentManager
            dialog.show(manager, "myDialog")
        }
        //val database = Firebase.database.reference

    }

}