package ar.com.wolox.android.example.ui.news

import ar.com.wolox.android.example.model.New

interface NewsView {
    fun fillNews(newsList: List<New>)
    fun refreshList()
    fun showEmptyNewsError()
    fun showExternalError()
    fun addMoreNews(news: List<New>)
}
