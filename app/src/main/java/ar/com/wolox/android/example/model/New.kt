package ar.com.wolox.android.example.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class New(val id: Int, @SerializedName("createdAt") val createdAt: String, val title: String, val picture: String, val text: String, var likes: List<Int>) : Serializable
