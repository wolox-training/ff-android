package ar.com.wolox.android.example.ui.login;

import javax.inject.Inject;
import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/** <b>LoginPresenter</b>. */
public class LoginPresenter extends BasePresenter<LoginView> {

    private final UserSession userSession;

    @Inject
    public LoginPresenter(final UserSession userSession) {
        this.userSession = userSession;
    }

    public void onLoginButtonClicked() {
        // TODO
    }

    public void onSignupClicked() {
        // TODO
    }

    public void onTermsAndConditionsClicked() {
        // TODO
    }
}
