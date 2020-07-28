package ar.com.wolox.android.example.ui.news

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.example.model.New
import ar.com.wolox.android.example.utils.DateUtil.Companion.formatDateTime
import kotlinx.android.synthetic.main.new_item.view.*
import org.ocpsoft.prettytime.PrettyTime
import java.util.Locale

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var newPhoto = view.vNewPhoto
    var newTitle = view.vNewTitle
    var newText = view.vNewText
    var newTimeAgo = view.vTimeAgo
    var newLike = view.vLike
    var layout = view.vNewContainer

    fun populate(new: New) {
        with(new) {
            newTitle.text = title
            newText.text = text
            newTimeAgo.text = PrettyTime(Locale.getDefault()).formatDateTime(createdAt)
            newPhoto.setImageURI(new.picture)
        }
    }
}
