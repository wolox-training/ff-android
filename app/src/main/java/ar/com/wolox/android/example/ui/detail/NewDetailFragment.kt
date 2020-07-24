package ar.com.wolox.android.example.ui.detail

import android.os.Bundle
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.New
import ar.com.wolox.wolmo.core.fragment.WolmoFragment

class NewDetailFragment : WolmoFragment<NewDetailPresenter>() {

    private lateinit var new: New

    override fun init() {
        new = arguments?.getSerializable(NEWS) as New
    }

    override fun layout() = R.layout.fragment_new_detail

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