package ar.com.wolox.android.example.ui.detail

import android.os.Bundle
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.New
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_new_detail.*
import org.joda.time.format.DateTimeFormat
import org.ocpsoft.prettytime.PrettyTime
import java.util.Locale
import javax.inject.Inject

class NewDetailFragment @Inject constructor() : WolmoFragment<NewDetailPresenter>() {

    private lateinit var new: New

    override fun init() {
        new = arguments?.getSerializable(NEWS) as New
        inflateNew(new)
    }

    override fun layout() = R.layout.fragment_new_detail

    private fun inflateNew(new: New) {
        with(new) {
            vNewDetailTitle.text = title
            vNewDetailBody.text = text
            vNewDetailTimeAgo.text = formatTime(createdAt)
            vNewDetailLike.isChecked = likes.isNotEmpty()
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

        fun newInstance(new: New): NewDetailFragment {
            val arguments = Bundle()
            arguments.putSerializable(NEWS, new)
            val fragment = NewDetailFragment()
            fragment.arguments = arguments
            return fragment
        }
    }
}