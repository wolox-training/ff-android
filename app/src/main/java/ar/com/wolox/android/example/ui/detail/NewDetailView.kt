package ar.com.wolox.android.example.ui.detail

import ar.com.wolox.android.example.model.New

interface NewDetailView {
    fun inflateNew(new: New)
    fun showLoadingIcon(isLoading: Boolean)
    fun showGenericError()
    fun updateLikes(likes: ArrayList<Int>)
    fun reloadNewDetails(new: New)
}
