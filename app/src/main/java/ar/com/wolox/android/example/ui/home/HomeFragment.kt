package ar.com.wolox.android.example.ui.home

import ar.com.wolox.android.R
import ar.com.wolox.android.example.ui.news.NewsFragment
import ar.com.wolox.android.example.ui.profile.ProfileFragment
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : WolmoFragment<HomePresenter>(), HomeView {

    @Inject
    lateinit var newsFragment: NewsFragment

    @Inject
    lateinit var profileFragment: ProfileFragment

    override fun layout() = R.layout.fragment_home

    override fun init() {
        val adapter = HomeFragmentAdapter(activity!!.supportFragmentManager)
        adapter.addFragment(newsFragment, "NEWS")
        adapter.addFragment(profileFragment, "PROFILE")
        vHomeViewPager.adapter = adapter
        vTabLayout.apply {
            vTabLayout.setupWithViewPager(vHomeViewPager)
            getTabAt(0)!!.setIcon(R.drawable.ic_news_list_selector).setText(getString(R.string.home_news_tab_title))
            getTabAt(1)!!.setIcon(R.drawable.ic_profile_selector).setText(getString(R.string.home_profile_tab_title))
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
