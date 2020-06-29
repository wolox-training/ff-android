package ar.com.wolox.android.example.ui.login;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/** <b>LoginPresenter</b>. */
public class LoginPresenter extends BasePresenter<LoginView> {

    private final String baseURL = "http://www.wolox.com.ar";
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
    public void onLoginButtonClicked(@NotNull String email, @NotNull String password) {
        List<LoginError> errors = validateLoginCredentials(email, password);
        if (errors.isEmpty()) {
            userSession.setUsername(email);
            userSession.setPassword(password);
            getView().goToHomeScreen();
        } else {
            for (LoginError error : errors) {
                error.callAction(getView());
            }
        }
    }

    public void onSignUpButtonClicked() {
        getView().goToSignUpScreen();
    }

    public void onTermsAndConditionsClicked() {
        getView().navigateToURL(baseURL);
    }

    private List<LoginError> validateLoginCredentials(@NotNull String email, @NotNull String password) {
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
        EMPTY_EMAIL {
            public void callAction(LoginView view) {
                view.showEmptyEmailError();
            }
        },
        EMPTY_PASSWORD {
            public void callAction(LoginView view) {
                view.showEmptyPasswordError();
            }
        },
        INVALID_EMAIL {
            public void callAction(LoginView view) {
                view.showInvalidEmailError();
            }
        };

        public abstract void callAction(LoginView view);
    }
}
