package ar.com.wolox.android.example.ui.main;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

/**
 * MainActivity
 */
public class MainActivity extends WolmoActivity {

    @Override
    protected int layout() {
        return R.layout.activity_base;
    }

    @Override
    protected void init() {
        replaceFragment(R.id.vActivityBaseContent, MainFragment.newInstance());
    }
}
