package ar.com.wolox.android.example.ui.news

import android.net.Uri
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.example.model.New
import kotlinx.android.synthetic.main.new_item.view.*
import org.joda.time.format.DateTimeFormat
import org.ocpsoft.prettytime.PrettyTime
import java.util.Locale

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var newPhoto = view.vNewPhoto
    var newTitle = view.vNewTitle
    var newText = view.vNewText
    var newTimeAgo = view.vTimeAgo
    var newLike = view.vLike

    fun populate(new: New) {
        with(new) {
            newTitle.text = title
            newText.text = text
            Log.d("ADGJASKFJHAKSJDASGKLJASDKA", createdAt)
            newTimeAgo.text = formatTime(createdAt)
            newPhoto.setImageURI(Uri.parse(new.picture))
        }
    }

    private fun formatTime(date: String): String? {
        val formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
        val dateTime = formatter.parseDateTime(date)
        val prettyTime = PrettyTime(Locale.getDefault())
        return prettyTime.format(dateTime.toDate())
    }
}
