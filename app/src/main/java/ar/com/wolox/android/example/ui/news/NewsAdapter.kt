package ar.com.wolox.android.example.ui.news

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.New

class NewsAdapter : ListAdapter<New, NewsAdapter.ViewHolder>(NewsDiffUtil()) {

    private lateinit var context: Context
    private lateinit var view: View
    var newsList = ArrayList<New>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var newPhoto = view.findViewById<ImageView>(R.id.vNewPhoto)
        var newTitle = view.findViewById<TextView>(R.id.vNewTitle)
        var newText = view.findViewById<TextView>(R.id.vNewText)
        var newTimeAgo = view.findViewById<TextView>(R.id.vTimeAgo)
        var newLike = view.findViewById<ToggleButton>(R.id.vLike)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        view = LayoutInflater.from(context).inflate(R.layout.new_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = newsList[position]

        holder.apply {
            newTitle.text = news.title
            newText.text = news.text
            newTimeAgo.text = news.createdAt
        }
    }

    override fun getItemCount() = newsList.size

    fun fillList(news: List<New>) {
        this.newsList.clear()
        this.newsList.addAll(news)
    }
}
