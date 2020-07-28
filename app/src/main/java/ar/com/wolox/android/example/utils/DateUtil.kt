package ar.com.wolox.android.example.utils

import org.joda.time.format.DateTimeFormat
import org.ocpsoft.prettytime.PrettyTime

class DateUtil {

    companion object {
        private const val DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"

        fun PrettyTime.formatDateTime(date: String): String? {
            val formatter = DateTimeFormat.forPattern(DATE_PATTERN)
            val dateTime = formatter.parseDateTime(date)
            return this.format(dateTime.toDate())
        }
    }
}
