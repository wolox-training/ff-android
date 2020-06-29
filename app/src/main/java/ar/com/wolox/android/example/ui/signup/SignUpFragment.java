package ar.com.wolox.android.example.ui.signup;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 * SignUpFragment
 */
public class SignUpFragment extends WolmoFragment<SignUpPresenter> {

    private static SignUpFragment instance;

    public static SignUpFragment newInstance() {
        if (instance == null) {
            instance = new SignUpFragment();
        }
        return instance;
    }

    @Override
    public void init() { }

    @Override
    public int layout() {
        return R.layout.fragment_sign_up;
    }
}
