package ar.com.wolox.android.example.externalServices

import ar.com.wolox.android.example.model.New
import retrofit2.Call
import retrofit2.http.GET

interface NewsService {

    @GET("/news")
    fun loadNews(): Call<List<New>>
}
