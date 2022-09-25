package com.edurda77.pulsenoote.presentation

import androidx.lifecycle.ViewModel
import com.edurda77.pulsenoote.repository.WorkWithDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DialogInputDataViewModel @Inject constructor(private val repository: WorkWithDatabase) :
    ViewModel() {
    fun addData(hp: Int, lp: Int, ps: Int) {
        repository.writeToDb(hp, lp, ps)
    }
}