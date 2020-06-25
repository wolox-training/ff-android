package ar.com.wolox.android.example.ui.login;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 LoginModule
 */
@Module
public abstract class LoginModule {

    @ContributesAndroidInjector
    public abstract LoginActivity loginActivity();

    @ContributesAndroidInjector
    public abstract LoginFragment loginFragment();
}
