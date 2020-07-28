package ar.com.wolox.android.example.ui.detail

import android.content.Context
import android.content.Intent
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.New
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import javax.inject.Inject

class NewDetailActivity @Inject constructor() : WolmoActivity() {

    override fun init() {
        replaceFragment(R.id.vActivityBaseContent, NewDetailFragment
                .newInstance(intent.getSerializableExtra(NEWS) as New,
                            intent.getSerializableExtra(USER_ID) as Int))
    }

    override fun layout() = R.layout.activity_base

    companion object {
        fun start(context: Context, new: New) {
            var userId = context.getSharedPreferences(USER_ID, Context.MODE_PRIVATE)!!.getInt("user_id", 0)
            val intent = Intent(context, NewDetailActivity::class.java)
            intent.apply {
                putExtra(NEWS, new)
                putExtra(USER_ID, userId)
            }
            // context?.getSharedPreferences("ar.com.wolox.android.example.ui.login", Context.MODE_PRIVATE)!!.getInt("user_id", 0)
            context.startActivity(intent)
        }

        private const val NEWS = "news"
        private const val USER_ID = "userId"
    }
}
