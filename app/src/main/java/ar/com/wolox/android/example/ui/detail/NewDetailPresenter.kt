package ar.com.wolox.android.example.ui.detail

import ar.com.wolox.android.example.externalServices.NewsService
import ar.com.wolox.android.example.model.New
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NewDetailPresenter @Inject constructor(private val retrofitServices: RetrofitServices) : BasePresenter<NewDetailView>() {

    private lateinit var new: New
    private var userId: Int? = null

    private var isLoading: Boolean = false
        set(value) {
            field = value
            view?.showLoadingIcon(value)
        }

    fun onInit(new: New, userId: Int) {
        this.new = new
        this.userId = userId
        view?.inflateNew(new)
    }

    fun onSwipeRefresh() {
        isLoading = true
        reloadNewDetails()
    }

    fun onLikeClick() {
        isLoading = true

        val call = retrofitServices.getService(NewsService::class.java).retrieveNew(new.id)
        call.enqueue(object : Callback<List<New>> {
            override fun onFailure(call: Call<List<New>>, t: Throwable) {
                isLoading = false
                view?.showGenericError()
            }

            override fun onResponse(call: Call<List<New>>, response: Response<List<New>>) {
                val new = response.body()!!.first()
                if (new?.likes.contains(userId)) {
                    (new.likes as ArrayList).remove(userId!!)
                } else {
                    (new.likes as ArrayList).add(userId!!)
                }
                view?.updateLikes(new.likes as ArrayList<Int>)
                isLoading = false
            }
        })
    }

    private fun reloadNewDetails() {
        val call = retrofitServices.getService(NewsService::class.java).retrieveNew(new.id)
        call.enqueue(object : Callback<List<New>> {
            override fun onFailure(call: Call<List<New>>, t: Throwable) {
                isLoading = false
                view?.showGenericError()
            }

            override fun onResponse(call: Call<List<New>>, response: Response<List<New>>) {
                isLoading = false
                view?.reloadNewDetails(response.body()!!.first())
            }
        })
    }
}
