package com.edurda77.pulsenoote.repository

import androidx.lifecycle.MutableLiveData
import com.edurda77.pulsenoote.entity.DataInput
import com.edurda77.pulsenoote.entity.DataTransfer
import com.edurda77.pulsenoote.entity.SubDataInput
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import java.util.*
import javax.inject.Inject

class WorkWithDatabase @Inject constructor (private val database : DatabaseReference) {

    /*init {
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val listRecords: List<DataTransfer> = dataSnapshot.children.map {
                    it.getValue(DataTransfer::class.java)!!
                }
                *//*val listRecords = mutableListOf<DataTransfer>()
                dataSnapshot.children.forEach {
                    val item = it.getValue<DataTransfer>()
                    if (item != null) {
                        listRecords.add(item)
                    }
                }*//*
                convertToShow(listRecords)
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
    }*/

    fun writeToDb(hp: Int, lp: Int, ps: Int) {
        val newRecord = DataTransfer(hp, lp, ps)
        database.child("record${Date()}").setValue(newRecord)
    }

    fun readDb(livaData: MutableLiveData<List<DataInput>>) {
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val listRecords: List<DataTransfer> = dataSnapshot.children.map {
                    it.getValue(DataTransfer::class.java)!!
                }
                /*val listRecords = mutableListOf<DataTransfer>()
                dataSnapshot.children.forEach {
                    val item = it.getValue<DataTransfer>()
                    if (item != null) {
                        listRecords.add(item)
                    }
                }*/

                livaData.postValue(convertToShow(listRecords))
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        database.addValueEventListener(postListener)
    }

    private fun convertToShow(list: List<DataTransfer>): List<DataInput> {
        val dataForShow = mutableListOf<DataInput>()
        val dateList = mutableListOf<String>()

        list.forEach {
            dateList.add(it.currentData)
        }
        val setDate = HashSet(dateList)
        setDate.forEach { itSetDate ->
            val tmpList = mutableListOf<SubDataInput>()
            list.forEach { itDate ->
                if (itDate.currentData == itSetDate) {
                    tmpList.add(
                        SubDataInput(
                            itDate.highPressure,
                            itDate.lowPressure,
                            itDate.pulse,
                            itDate.time
                        )
                    )
                }
            }
            dataForShow.add(DataInput(itSetDate, tmpList))

        }
        return dataForShow.sortedBy { it.date }
    }

}