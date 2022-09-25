package com.edurda77.pulsenoote.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edurda77.pulsenoote.entity.DataInput
import com.edurda77.pulsenoote.repository.WorkWithDatabase
import com.edurda77.pulsenoote.utils.StateMainActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: WorkWithDatabase) :
    ViewModel() {
    private val _dataForShow = MutableLiveData<List<DataInput>>()
    val dataForShow  = _dataForShow
    private val _showData = MutableLiveData<StateMainActivity>(StateMainActivity.Empty)
    val showData = _showData
    init {
        getData()
    }
     private fun getData() {
         repository.readDb(_dataForShow)
        /* _showData.value = StateMainActivity.Loading
         try {

                 repository.readDb(_dataForShow)

             _showData.value = StateMainActivity.Success(_dataForShow)
         } catch (error: Exception) {
             _showData.value = StateMainActivity.Failure(error.toString())
         }*/
     }
}