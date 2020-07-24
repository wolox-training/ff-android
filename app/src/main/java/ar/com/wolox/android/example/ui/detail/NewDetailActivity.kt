package ar.com.wolox.android.example.ui.detail

import android.content.Context
import android.content.Intent
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.New
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import javax.inject.Inject

class NewDetailActivity @Inject constructor() : WolmoActivity() {

    override fun init() {
        replaceFragment(R.id.vActivityBaseContent, NewDetailFragment.newInstance(intent.getSerializableExtra(NEWS) as New))
    }

    override fun layout() = R.layout.activity_base

    companion object {
        fun start(context: Context, new: New) {
            val intent = Intent(context, NewDetailActivity::class.java)
            intent.putExtra(NEWS, new)
            context.startActivity(intent)
        }

        private const val NEWS = "news"
    }
}