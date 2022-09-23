package com.edurda77.pulsenoote.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edurda77.pulsenoote.repository.WorkWithDatabase
import com.edurda77.pulsenoote.utils.StateMainActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: WorkWithDatabase) :
    ViewModel() {
    private val _showData = MutableLiveData<StateMainActivity>(StateMainActivity.Empty)
    val showData = _showData
    init {
        getData()
    }
     private fun getData() {
         _showData.value = StateMainActivity.Loading
         try {
             _showData.value = StateMainActivity.Success(repository.readDb())
         } catch (error: Exception) {
             _showData.value = StateMainActivity.Failure(error.toString())
         }
     }
}