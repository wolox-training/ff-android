package ar.com.wolox.android.example.ui.home

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment

class HomeFragment : WolmoFragment<HomePresenter>() {

    override fun init() { }

    override fun layout(): Int {
        return R.layout.fragment_home
    }

    companion object {
        val instance = HomeFragment()
    }
}
