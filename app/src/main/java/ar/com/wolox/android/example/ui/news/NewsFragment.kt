package ar.com.wolox.android.example.ui.news

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
        vNewsRecyclerView.apply {
            vNewsRecyclerView.layoutManager = LinearLayoutManager(activity)
            vNewsRecyclerView.adapter = newsAdapter
        }
        presenter.fillList()
        vSwipeRefresh.setOnRefreshListener { presenter.onSwipeRefresh() }
    }

    companion object {
        fun newInstance() = NewsFragment()
    }

    override fun fillNews(newsList: List<New>) {
        newsAdapter.fillList(newsList)
        newsAdapter.notifyDataSetChanged()
        vSwipeRefresh.isRefreshing = false
    }

    override fun refreshList() {
        vSwipeRefresh.isRefreshing = true
        presenter.fillList()
    }
}
