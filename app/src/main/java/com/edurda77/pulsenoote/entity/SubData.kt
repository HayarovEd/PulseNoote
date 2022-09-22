package com.edurda77.pulsenoote.entity

import com.edurda77.pulsenoote.utils.getCurrentTimeToString

data class SubData(
    val highPressure: Int? = 0,
    val lowPressure: Int? = 0,
    val pulse: Int? = 0
)  {
    val time = getCurrentTimeToString()
}
