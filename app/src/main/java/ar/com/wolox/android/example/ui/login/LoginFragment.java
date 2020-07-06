package ar.com.wolox.android.example.ui.login;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeActivity;
import ar.com.wolox.android.example.ui.signup.SignUpActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/** LoginFragment. */
public class LoginFragment extends WolmoFragment<LoginPresenter> implements LoginView {

    private static LoginFragment instance;
    private TextView email;
    private TextView password;
    private Button loginButton;
    private Button signUpButton;
    private TextView termsAndConditions;
    private ProgressBar loadingProgressBar;

    public static LoginFragment newInstance() {
        if (instance == null) {
            instance = new LoginFragment();
        }
        return instance;
    }

    @Override
    public void init() {
        email = getView().findViewById(R.id.vEmailField);
        password = getView().findViewById(R.id.vPasswordField);
        loginButton = getView().findViewById(R.id.vLoginButton);
        signUpButton = getView().findViewById(R.id.vSignUpButton);
        termsAndConditions = getView().findViewById(R.id.vTermsText);
        loadingProgressBar = getActivity().findViewById(R.id.vProgressBar);
    }

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void setListeners() {
        loginButton.setOnClickListener(it -> getPresenter()
                .onLoginButtonClicked(email.getText().toString(), password.getText().toString()));
        signUpButton.setOnClickListener(it -> getPresenter()
                .onSignUpButtonClicked());
        termsAndConditions.setOnClickListener(it -> getPresenter()
                .onTermsAndConditionsClicked());
    }

    @Override
    public void goToHomeScreen() {
        HomeActivity.start(getContext());
    }

    @Override
    public void goToSignUpScreen() {
        SignUpActivity.start(getContext());
    }

    @Override
    public void navigateToTermsURL() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.woloxUrl)));
        startActivity(intent);
    }

    @Override
    public void showEmptyEmailError() {
        email.setError(getString(R.string.empty_email_error));
    }

    @Override
    public void showInvalidEmailError() {
        email.setError(getString(R.string.invalid_email_error));
    }

    @Override
    public void showEmptyPasswordError() {
        password.setError(getString(R.string.empty_password_error));
    }

    @Override
    public void showProgressBar() {
        loadingProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        loadingProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showCredentialsError() {
        showToastNotification(R.string.login_credentials_error);
    }

    @Override
    public void showConnectionError() {
        showToastNotification(R.string.internet_connection_error);
    }

    @Override
    public void showUnknownError() {
        showToastNotification(R.string.login_unknown_error);
    }

    private void showToastNotification(int messageId) {
        Toast toast = Toast.makeText(this.getContext(), messageId, Toast.LENGTH_LONG);
        toast.show();
    }
}
