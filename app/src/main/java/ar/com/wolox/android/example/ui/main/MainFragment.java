package ar.com.wolox.android.example.ui.main;

import android.content.Intent;
import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeActivity;
import ar.com.wolox.android.example.ui.login.LoginActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 * MainFragment
 */
public class MainFragment extends WolmoFragment<MainPresenter> implements MainView {

    private static MainFragment instance;

    public static MainFragment newInstance() {
        if (instance == null) {
            instance = new MainFragment();
        }
        return instance;
    }

    @Override
    public void init() {
        getPresenter().loadCredentials();
    }

    @Override
    public int layout() {
        return R.layout.activity_base;
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToLogin() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
}
