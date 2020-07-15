package ar.com.wolox.android.example.ui.news

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.example.model.New
import kotlinx.android.synthetic.main.new_item.view.*

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var newPhoto = view.vNewPhoto
    var newTitle = view.vNewTitle
    var newText = view.vNewText
    var newTimeAgo = view.vTimeAgo
    var newLike = view.vLike

    fun populate(new: New) {
        newTitle.text = new.title
        newText.text = new.text
        newTimeAgo.text = new.createdAt
    }
}
