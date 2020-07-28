package ar.com.wolox.android.example.externalServices

import ar.com.wolox.android.example.model.New
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("/news")
    fun loadNews(): Call<List<New>>

    @GET("/news")
    fun retrieveNew(@Query("id") newId: Int): Call<List<New>>
}
