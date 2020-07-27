package ar.com.wolox.android.example.ui.detail

import android.os.Bundle
import android.widget.Toast
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.New
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_new_detail.*
import org.joda.time.format.DateTimeFormat
import org.ocpsoft.prettytime.PrettyTime
import java.util.Locale
import javax.inject.Inject

class NewDetailFragment @Inject constructor() : WolmoFragment<NewDetailPresenter>(), NewDetailView {

    private lateinit var new: New
    private var userId: Int? = null

    override fun init() {
        new = arguments?.getSerializable(NEWS) as New
        userId = arguments?.getSerializable(USER_ID) as Int
        inflateNew(new)
        presenter.setDisplayedNew(new)
    }

    override fun layout() = R.layout.fragment_new_detail

    override fun setListeners() {
        vNewDetailSwipeRefresh.setOnRefreshListener {
            presenter.onSwipeRefresh()
        }

        vNewDetailLike.setOnClickListener {
            presenter.onLikeClick(userId)
        }

        vNewDetailHeaderBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun inflateNew(new: New) {
        with(new) {
            vNewDetailTitle.text = title
            vNewDetailBody.text = text
            vNewDetailTimeAgo.text = formatTime(createdAt)
            vNewDetailLike.isChecked = new.likes.contains(userId)
            vNewDetailImage.setImageURI(picture)
        }
    }

    private fun formatTime(date: String): String? {
        val formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
        val dateTime = formatter.parseDateTime(date)
        val prettyTime = PrettyTime(Locale.getDefault())
        return prettyTime.format(dateTime.toDate())
    }

    companion object {
        private const val NEWS = "news"
        private const val USER_ID = "userId"

        fun newInstance(new: New, userId: Int): NewDetailFragment {
            val arguments = Bundle()
            arguments.putSerializable(NEWS, new)
            arguments.putSerializable(USER_ID, userId)
            val fragment = NewDetailFragment()
            fragment.arguments = arguments
            return fragment
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
}
