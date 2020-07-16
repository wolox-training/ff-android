package ar.com.wolox.android.example.ui.news

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.New
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject

/**
 * NewsFragment
 */
class NewsFragment @Inject constructor() : WolmoFragment<NewsPresenter>(), NewsView {

    private var newsAdapter = NewsAdapter()

    override fun layout() = R.layout.fragment_news

    override fun init() {
        with(vNewsRecyclerView) {
            layoutManager = LinearLayoutManager(activity)
            adapter = newsAdapter
        }
        presenter.fillList()
        vSwipeRefresh.setOnRefreshListener { presenter.onSwipeRefresh() }
    }

    companion object {
        fun newInstance() = NewsFragment()
    }

    override fun fillNews(newsList: List<New>) {
        with(newsAdapter) {
            fillList(newsList)
            notifyDataSetChanged()
        }
        vSwipeRefresh.isRefreshing = false
    }

    override fun refreshList() {
        vSwipeRefresh.isRefreshing = true
        presenter.fillList()
    }

    override fun showEmptyNewsError() {
        showToastNotification(R.string.empty_news_error)
    }

    override fun showExternalError() {
        showToastNotification(R.string.news_service_error)
    }

    private fun showToastNotification(messageId: Int) {
        Toast.makeText(activity, messageId, Toast.LENGTH_LONG).show()
    }
}
