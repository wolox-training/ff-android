package ar.com.wolox.android.example.ui.news

import android.content.SharedPreferences
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.New
import ar.com.wolox.android.example.ui.detail.NewDetailActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject

/**
 * NewsFragment
 */
class NewsFragment @Inject constructor() : WolmoFragment<NewsPresenter>(), NewsView {

    private lateinit var sharedPreferences: SharedPreferences
    private var newsAdapter = NewsAdapter(this)

    override fun layout() = R.layout.fragment_news

    override fun init() {
        with(vNewsRecyclerView) {
            layoutManager = LinearLayoutManager(activity)
            adapter = newsAdapter
        }
        presenter.fillList()
        vSwipeRefresh.setOnRefreshListener { presenter.onSwipeRefresh() }

        vNewsRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                if (layoutManager.itemCount <= layoutManager.findLastVisibleItemPosition() + THRESHOLD) {
                    presenter.addItemsToEndOfList()
                }
            }
        })
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

    override fun addMoreNews(news: List<New>) {
        newsAdapter!!.addNews(news)
    }

    override fun onNewClick(new: New) {
        NewDetailActivity.start(requireContext(), new)
    }

    private fun showToastNotification(messageId: Int) {
        Toast.makeText(activity, messageId, Toast.LENGTH_LONG).show()
    }

    companion object {
        fun newInstance() = NewsFragment()
        private const val THRESHOLD = 3
    }
}
