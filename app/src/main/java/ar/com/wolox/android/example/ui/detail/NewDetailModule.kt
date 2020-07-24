package ar.com.wolox.android.example.ui.detail

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NewDetailModule {

    @ContributesAndroidInjector
    internal abstract fun newDetailActivity(): NewDetailActivity

    @ContributesAndroidInjector
    internal abstract fun newDetailFragment(): NewDetailFragment
}
