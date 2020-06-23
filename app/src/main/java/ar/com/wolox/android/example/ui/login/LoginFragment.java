package ar.com.wolox.android.example.ui.login;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/** LoginFragment. */
public class LoginFragment extends WolmoFragment<LoginPresenter> implements LoginView {

    private static LoginFragment instance;
    private TextView email;
    private TextView password;
    private Button loginButton;
    private Button signupButton;
    private TextView termsAndConditions;

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
        signupButton = getView().findViewById(R.id.vSignUpButton);
        termsAndConditions = getView().findViewById(R.id.vTermsText);
    }

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void setListeners() {
        loginButton.setOnClickListener(it -> getPresenter()
                .onLoginButtonClicked(email.getText().toString(), password.getText().toString()));
    }

    @Override
    public void goToHomeScreen() {
        Intent intent = new Intent(getActivity(), HomeActivity.class);
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
}
