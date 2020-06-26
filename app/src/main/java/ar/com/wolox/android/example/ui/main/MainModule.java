package ar.com.wolox.android.example.ui.main;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainModule {

    @ContributesAndroidInjector
    protected abstract MainActivity mainActivity();
}
