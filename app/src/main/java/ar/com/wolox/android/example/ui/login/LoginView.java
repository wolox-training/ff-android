package ar.com.wolox.android.example.ui.login;

/**
 LoginView
 */
public interface LoginView {
    void goToHomeScreen();
    void goToSignUpScreen();
    void navigateToTermsURL();
    void showEmptyEmailError();
    void showEmptyPasswordError();
    void showInvalidEmailError();
}
