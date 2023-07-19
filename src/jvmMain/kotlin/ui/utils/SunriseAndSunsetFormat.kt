package ui.utils

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter


fun convertFromUnixToDate(unix: Long): String {
    val zoneId = ZoneId.of(ZoneId.systemDefault().id)
    val time = LocalDateTime.ofInstant(Instant.ofEpochSecond(unix), zoneId)
    val formatter = DateTimeFormatter.ofPattern("hh:mm a")

    return time.format(formatter)
}