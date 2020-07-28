package ar.com.wolox.android.example.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.New

class NewsAdapter(private val listener: NewsView) : ListAdapter<New, NewsViewHolder>(NewsDiffUtil()) {

    private lateinit var view: View
    var news = ArrayList<New>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.new_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        var new = news[position]
        with(holder) {
            layout.setOnClickListener {
                listener.onNewClick(new)
            }
            populate(news[position])
        }
    }

    override fun getItemCount() = news.size

    fun fillList(newsToFill: List<New>) {
        with(news) {
            clear()
            addAll(newsToFill)
        }
    }

    fun addNews(newsToAdd: List<New>) {
        news.addAll(newsToAdd)
        notifyDataSetChanged()
    }
}
