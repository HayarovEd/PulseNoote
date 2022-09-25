package com.edurda77.pulsenoote.utils

import androidx.lifecycle.MutableLiveData
import com.edurda77.pulsenoote.entity.DataInput

sealed class StateMainActivity {
    object Loading : StateMainActivity()
    class Failure(val error:String) : StateMainActivity()
    class Success(val data: MutableLiveData<List<DataInput>>) : StateMainActivity()
    object Empty : StateMainActivity()
}

