package com.edurda77.pulsenoote.repository

import com.edurda77.pulsenoote.entity.DataInput
import com.edurda77.pulsenoote.entity.DataTransfer
import com.edurda77.pulsenoote.entity.SubDataInput
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import java.util.*
import javax.inject.Inject

class WorkWithDatabase @Inject constructor (private val database : DatabaseReference) {
    private val dataForShow = mutableListOf<DataInput>()

    fun writeToDb(hp: Int, lp: Int, ps: Int) {
        val newRecord = DataTransfer(hp, lp, ps)
        database.child("record${Date()}").setValue(newRecord)
    }

    fun readDb(): List<DataInput> {
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val listRecords = mutableListOf<DataTransfer>()
                dataSnapshot.children.forEach {
                    val item = it.getValue<DataTransfer>()
                    if (item != null) {
                        listRecords.add(item)
                    }
                }
                convertToShow(listRecords)
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        database.addValueEventListener(postListener)
        return dataForShow
    }

    private fun convertToShow(list: MutableList<DataTransfer>): List<DataInput> {
        dataForShow.clear()
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
        return dataForShow
    }

}