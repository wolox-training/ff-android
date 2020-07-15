package ar.com.wolox.android.example.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class HomeFragmentAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val fragments: ArrayList<Fragment> = ArrayList()
    private val fragmentNames: ArrayList<String> = ArrayList()

    override fun getItem(position: Int) = fragments[position]

    override fun getCount() = fragments.size

    fun addFragment(fragment: Fragment, tabName: String) {
        fragments.add(fragment)
        fragmentNames.add(tabName)
    }
}
