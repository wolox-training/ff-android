package ar.com.wolox.android.example.ui.main;

import android.content.Intent;

import com.facebook.drawee.backends.pipeline.Fresco;

import javax.inject.Inject;
import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeActivity;
import ar.com.wolox.android.example.ui.login.LoginActivity;
import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

/**
 * MainActivity
 */
public class MainActivity extends WolmoActivity {

    @Inject
    public UserSession userSession;

    @Override
    protected int layout() {
        return R.layout.activity_base;
    }

    @Override
    protected void init() {
        Fresco.initialize(this);
        checkUserSession();
    }

    private void checkUserSession() {
        if (userSession.isUserLogged()) {
            navigateToHome();
        } else {
            navigateToLogin();
        }
    }
    private void navigateToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    private void navigateToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
