package com.edurda77.pulsenoote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.edurda77.pulsenoote.databinding.ActivityMainBinding
import com.edurda77.pulsenoote.entity.FullData
import com.edurda77.pulsenoote.entity.FullDataInput
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            val dialog = DialogInputData()
            val manager = supportFragmentManager
            dialog.show(manager, "myDialog")
        }
        val database = Firebase.database.reference
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val listRecords = mutableListOf<FullData>()
                dataSnapshot.children.forEach {
                    val item = it.getValue<FullData>()
                    if (item != null) {
                        listRecords.add(item)
                    }
                }


                listRecords.forEach {
                    println(it.currentData)
                    println(it.time)
                    println(it.highPressure)
                    println(it.lowPressure)
                    println(it.pulse)
                }
            }


            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        database.addValueEventListener(postListener)

    }

}