package ar.com.wolox.android.example.ui.login;

/**
 LoginView
 */
public interface LoginView {
    void goToHomeScreen();
    void goToSignUpScreen();
    void navigateToURL(String baseUrl);
    void showEmptyEmailError();
    void showEmptyPasswordError();
    void showInvalidEmailError();
    void showProgressBar();
    void hideProgressBar();
    void showCredentialsError();
    void showConnectionError();
    void showUnknownError();
}
