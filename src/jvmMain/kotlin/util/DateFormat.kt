package util

import java.text.SimpleDateFormat
import java.util.*

fun convertToUserFriendlyDate(dateString: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
    val outputFormat = SimpleDateFormat("d MMMM", Locale.US)
    val date = inputFormat.parse(dateString)
    return outputFormat.format(date)
}
fun convertToTimeFormat(dateString: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
    val outputFormat = SimpleDateFormat("h a", Locale.US)
    val date = inputFormat.parse(dateString)
    return outputFormat.format(date)
}