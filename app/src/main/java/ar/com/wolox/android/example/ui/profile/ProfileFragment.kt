package ar.com.wolox.android.example.ui.profile

import ar.com.wolox.android.R
import ar.com.wolox.android.example.ui.home.HomePresenter
import ar.com.wolox.android.example.ui.home.HomeView
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

/**
 * Profile fragment
 */
class ProfileFragment @Inject constructor() : WolmoFragment<HomePresenter>(), HomeView {

    override fun layout() = R.layout.fragment_profile

    override fun init() {}

    companion object {
        fun newInstance() = ProfileFragment()
    }
}
