package com.edurda77.pulsenoote.utils

import java.text.Format
import java.text.SimpleDateFormat
import java.time.format.FormatStyle
import java.util.*

fun getCurrentTimeToString(): String {
    val formatter = SimpleDateFormat("hh:mm:ss a")
    return formatter.format(Date())
}

fun getCurrantDate () : String {
    val local = Locale("ru")
    val formatter = SimpleDateFormat("dd:MM:yyyy", local)
    return formatter.format(Date())
}
