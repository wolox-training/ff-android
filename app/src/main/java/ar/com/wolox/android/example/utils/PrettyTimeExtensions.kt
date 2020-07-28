package ar.com.wolox.android.example.utils

import org.joda.time.format.DateTimeFormat
import org.ocpsoft.prettytime.PrettyTime

fun PrettyTime.formatDateTime(date: String, pattern: String): String? {
    val formatter = DateTimeFormat.forPattern(pattern)
    val dateTime = formatter.parseDateTime(date)
    return this.format(dateTime.toDate())
}
