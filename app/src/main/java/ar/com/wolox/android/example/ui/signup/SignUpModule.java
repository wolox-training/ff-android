package ar.com.wolox.android.example.ui.signup;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 SignUpModule
 */
@Module
public abstract class SignUpModule {

    @ContributesAndroidInjector
    public abstract SignUpActivity loginActivity();

    @ContributesAndroidInjector
    public abstract SignUpFragment signUpFragment();
}
