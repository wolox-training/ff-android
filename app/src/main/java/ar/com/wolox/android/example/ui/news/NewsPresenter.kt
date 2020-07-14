package ar.com.wolox.android.example.ui.news

import ar.com.wolox.android.example.model.New
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class NewsPresenter @Inject constructor() : BasePresenter<NewsView>() {

    private val times: Int = 10

    fun fillList() {
        var list: ArrayList<New> = ArrayList()

        for (i in 1 until times)
            list.add(New(i, "15m", "Ali Connors", "Picture", "I'll be in your neighborhood doing errands ..."))

        view!!.fillNews(list)
    }
}
