package ar.com.wolox.android.example.ui.home;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 HomeModule
 */
@Module
public abstract class HomeModule {

    @ContributesAndroidInjector
    public abstract HomeActivity homeActivity();

    @ContributesAndroidInjector
    public abstract HomeFragment homeFragment();
}
