package com.edurda77.pulsenoote.utils

import com.edurda77.pulsenoote.entity.DataInput

sealed class StateMainActivity {
    object Loading : StateMainActivity()
    class Failure(val error:String) : StateMainActivity()
    class Success(val data: List<DataInput>) : StateMainActivity()
    object Empty : StateMainActivity()
}

