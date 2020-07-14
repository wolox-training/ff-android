package ar.com.wolox.android.example.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class HomeFragmentAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val mFragmentList: ArrayList<Fragment> = ArrayList()
    private val mFragmentListNames: ArrayList<String> = ArrayList()

    override fun getItem(position: Int) = mFragmentList[position]

    override fun getCount() = mFragmentList.size

    fun addFragment(fragment: Fragment, tabName: String) {
        mFragmentList.add(fragment)
        mFragmentListNames.add(tabName)
    }
}