package ar.com.wolox.android.example.ui.detail

import android.os.Bundle
import android.widget.Toast
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.New
import ar.com.wolox.android.example.utils.formatDateTime
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_new_detail.*
import org.ocpsoft.prettytime.PrettyTime
import java.util.Locale
import javax.inject.Inject

class NewDetailFragment @Inject constructor() : WolmoFragment<NewDetailPresenter>(), NewDetailView {

    private lateinit var new: New
    private var userId: Int? = null

    override fun init() {
        var new = arguments?.getSerializable(NEWS) as New
        var userId = arguments?.getSerializable(USER_ID) as Int
        presenter.onInit(new, userId)
    }

    override fun layout() = R.layout.fragment_new_detail

    override fun setListeners() {
        vNewDetailSwipeRefresh.setOnRefreshListener {
            presenter.onSwipeRefresh()
        }

        vNewDetailLike.setOnClickListener {
            presenter.onLikeClick()
        }

        vNewDetailHeaderBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    override fun inflateNew(new: New) {
        with(new) {
            vNewDetailTitle.text = title
            vNewDetailBody.text = text
            vNewDetailTimeAgo.text = PrettyTime(Locale.getDefault()).formatDateTime(createdAt, DATE_PATTERN)
            vNewDetailLike.isChecked = new.likes.contains(userId)
            vNewDetailImage.setImageURI(picture)
        }
    }

    override fun showLoadingIcon(isLoading: Boolean) {
        vNewDetailSwipeRefresh.isRefreshing = isLoading
    }

    override fun showGenericError() {
        Toast.makeText(context, R.string.new_details_failure, Toast.LENGTH_LONG).show()
    }

    override fun updateLikes(likes: ArrayList<Int>) {
        new.likes = likes
        vNewDetailLike.isSelected = new.likes.contains(userId)
    }

    override fun reloadNewDetails(new: New) {
        inflateNew(new)
    }

    companion object {
        private const val NEWS = "news"
        private const val USER_ID = "userId"
        private const val DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"

        fun newInstance(new: New, userId: Int): NewDetailFragment {
            val arguments = Bundle().apply {
                putSerializable(NEWS, new)
                putSerializable(USER_ID, userId)
            }
            val fragment = NewDetailFragment()
            fragment.arguments = arguments
            return fragment
        }
    }
}
