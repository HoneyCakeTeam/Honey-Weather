package ui.utils

import java.util.*

fun isNight(): Boolean {
    val currentTime = Date()

    val calendar = Calendar.getInstance()
    calendar.time = currentTime

    val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)

    return hourOfDay < 6 || hourOfDay >= 18
}