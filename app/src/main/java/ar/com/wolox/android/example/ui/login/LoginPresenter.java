package ar.com.wolox.android.example.ui.login;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import ar.com.wolox.android.example.externalServices.AuthenticationService;
import ar.com.wolox.android.example.model.User;
import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/** <b>LoginPresenter</b>. */
public class LoginPresenter extends BasePresenter<LoginView> {

    private final String woloxURL = "http://www.wolox.com.ar";
    private UserSession userSession;
    private RetrofitServices retrofitServices;

    @Inject
    public LoginPresenter(UserSession userSession, RetrofitServices retrofitServices) {
        this.userSession = userSession;
        this.retrofitServices = retrofitServices;
    }

    private final String emailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    /**
     * @param email email field, must not be empty
     * @param password password field, must not be empty
     */
    public void onLoginButtonClicked(@NotNull String email, @NotNull String password) {
        List<LoginError> errors = validateLoginCredentialsFormat(email, password);
        if (errors.isEmpty()) {
            authenticate(email, password);
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
        getView().navigateToURL(woloxURL);
    }

    private List<LoginError> validateLoginCredentialsFormat(@NotNull String email, @NotNull String password) {
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

    private void authenticate(String email, String password) {
        AuthenticationService authenticationService = retrofitServices.getService(AuthenticationService.class);
        authenticationService.findUser(email).enqueue(login(email, password));
    }

    private Callback<List<User>> login(String email, String password) {
        getView().showProgressBar();
        return new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> matchingUsers = response.body();
                if (credentialsAreValid(matchingUsers, password)) {
                    userSession.setUsername(email);
                    userSession.setPassword(password);
                    getView().goToHomeScreen();
                } else {
                    getView().showCredentialsError();
                }
                getView().hideProgressBar();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                if (t instanceof IOException) {
                    getView().hideProgressBar();
                    getView().showConnectionError();
                } else {
                    getView().showUnknownError();
                }
            }
        };
    }

    private boolean credentialsAreValid(List<User> matchingUsers, String password) {
        return matchingUsers != null && !matchingUsers.isEmpty() && password.equals(matchingUsers.get(0).getPassword());
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
