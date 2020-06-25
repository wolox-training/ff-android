package ar.com.wolox.android.example.ui.main;

import android.util.Log;

import javax.inject.Inject;
import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/**
 * MainPresenter
 */
public class MainPresenter extends BasePresenter<MainView> {

    private UserSession userSession;

    @Inject
    public MainPresenter(UserSession userSession) {
        this.userSession = userSession;
    }

    public void loadCredentials() {
        if (userSession.isUserLogged()) {
            if (isViewAttached()) {
                getView().navigateToHome();
            }
        } else {
            if (isViewAttached()) {
                getView().navigateToLogin();
            }
        }
    }
}
