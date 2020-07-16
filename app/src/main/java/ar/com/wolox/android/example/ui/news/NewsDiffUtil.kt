package ar.com.wolox.android.example.ui.news

import androidx.recyclerview.widget.DiffUtil
import ar.com.wolox.android.example.model.New

class NewsDiffUtil : DiffUtil.ItemCallback<New>() {
    override fun areItemsTheSame(oldItem: New, newItem: New): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: New, newItem: New): Boolean {
        return oldItem == newItem
    }
}
