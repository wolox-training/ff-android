package ar.com.wolox.android.example.ui.home

import androidx.viewpager.widget.ViewPager
import ar.com.wolox.android.R
import ar.com.wolox.android.example.ui.news.NewsFragment
import ar.com.wolox.android.example.ui.profile.ProfileFragment
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : WolmoFragment<HomePresenter>(), HomeView {

    @Inject
    lateinit var newsFragment: NewsFragment

    @Inject
    lateinit var profileFragment: ProfileFragment

    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout

    override fun layout() = R.layout.fragment_home

    override fun init() {
        val adapter = HomeFragmentAdapter(activity!!.supportFragmentManager)
        adapter.addFragment(newsFragment)
        adapter.addFragment(profileFragment)
        vHomeViewPager.adapter = adapter
        vTabLayout.setupWithViewPager(viewPager)
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
