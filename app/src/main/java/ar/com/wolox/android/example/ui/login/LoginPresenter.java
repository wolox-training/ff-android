package ar.com.wolox.android.example.ui.login;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/** <b>LoginPresenter</b>. */
public class LoginPresenter extends BasePresenter<LoginView> {

    private UserSession userSession;

    @Inject
    public LoginPresenter(UserSession userSession) {
        this.userSession = userSession;
    }

    private final String emailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    /**
     * @param email email field, must not be empty
     * @param password password field, must not be empty
     */
    public void onLoginButtonClicked(String email, String password) {
        List<LoginError> errors = validateLoginCredentials(email, password);
        if (!errors.isEmpty()) {
            if (errors.contains(LoginError.EMPTY_EMAIL)) {
                getView().showEmptyEmailError();
            }
            if (errors.contains(LoginError.EMPTY_PASSWORD)) {
                getView().showEmptyPasswordError();
            }
            if (errors.contains(LoginError.INVALID_EMAIL)) {
                getView().showInvalidEmailError();
            }
        } else {
            userSession.setUsername(email);
            userSession.setPassword(password);
            getView().goToHomeScreen();
        }
    }

    public void onSignUpButtonClicked() {
        // TODO
    }

    public void onTermsAndConditionsClicked() {
        // TODO
    }

    private List<LoginError> validateLoginCredentials(String email, String password) {
        List<LoginError> errors = new ArrayList<>();
        if (email.isEmpty()) {
            errors.add(LoginError.EMPTY_EMAIL);
        } else if (!email.matches(emailRegex)) {
            errors.add(LoginError.INVALID_EMAIL);
        }
        if (password.isEmpty()) {
            errors.add(LoginError.EMPTY_PASSWORD);
        }
        return errors;
    }

    private enum LoginError {
        EMPTY_EMAIL,
        EMPTY_PASSWORD,
        INVALID_EMAIL
    }
}
