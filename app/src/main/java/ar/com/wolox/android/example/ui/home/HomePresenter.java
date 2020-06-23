package ar.com.wolox.android.example.ui.home;

import javax.inject.Inject;
import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/** <b>HomePresenter</b>. */
public class HomePresenter extends BasePresenter<HomeView> {

    @Inject
    public HomePresenter(final UserSession userSession) {
    }
}
