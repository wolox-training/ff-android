package ar.com.wolox.android.example.ui.home

import android.content.Context
import android.content.Intent
import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class HomeActivity : WolmoActivity() {

    override fun layout(): Int {
        return R.layout.activity_base
    }

    override fun init() {
        replaceFragment(R.id.vActivityBaseContent, HomeFragment.instance)
    }

    fun start(context: Context) {
        val intent = Intent(context, HomeActivity::class.java)
        startActivity(intent)
    }
}
