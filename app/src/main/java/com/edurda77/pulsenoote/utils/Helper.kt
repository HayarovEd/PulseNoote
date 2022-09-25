package com.edurda77.pulsenoote.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun getCurrentTimeToString(): String {
    val formatter = SimpleDateFormat("hh:mm:ss a")
    return formatter.format(Date())
}

fun getCurrantDate () : String {
    val local = Locale("ru")
    val formatter = SimpleDateFormat("dd:MM:yyyy", local)
    return formatter.format(Date())
}
