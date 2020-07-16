package ar.com.wolox.android.example.ui.news

import ar.com.wolox.android.example.externalServices.NewsService
import ar.com.wolox.android.example.model.New
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import kotlinx.android.synthetic.main.fragment_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NewsPresenter @Inject constructor(private val retrofitService: RetrofitServices) : BasePresenter<NewsView>() {

    private val times: Int = 10

    fun fillList() {
        val serviceCall = retrofitService?.getService(NewsService::class.java).loadNews()
        serviceCall.enqueue(object : Callback<List<New>> {
            override fun onResponse(call: Call<List<New>>, response: Response<List<New>>) {
                if (response.body()!!.isEmpty()) {
                    view!!.showEmptyNewsError()
                } else {
                    view!!.fillNews(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<New>>, t: Throwable) {
                view!!.showExternalError()
            }
        })
    }

    fun onSwipeRefresh() {
        view!!.refreshList()
    }
}
