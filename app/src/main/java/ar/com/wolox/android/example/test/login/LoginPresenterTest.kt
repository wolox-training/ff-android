package ar.com.wolox.android.example.test.login

import ar.com.wolox.android.example.externalServices.AuthenticationService
import ar.com.wolox.android.example.test.mocks.AuthenticationServiceMock
import ar.com.wolox.android.example.ui.login.LoginPresenter
import ar.com.wolox.android.example.ui.login.LoginView
import ar.com.wolox.android.example.utils.Extras.AuthenticationCredentials.EMAIL
import ar.com.wolox.android.example.utils.Extras.AuthenticationCredentials.EMPTY_EMAIL
import ar.com.wolox.android.example.utils.Extras.AuthenticationCredentials.INVALID_EMAIL
import ar.com.wolox.android.example.utils.Extras.AuthenticationCredentials.INVALID_PASSWORD
import ar.com.wolox.android.example.utils.Extras.AuthenticationCredentials.PASSWORD
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.tests.WolmoPresenterTest
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.Mockito.times

class LoginPresenterTest : WolmoPresenterTest<LoginView, LoginPresenter>() {

    @Mock
    lateinit var userSession: UserSession

    @Mock
    lateinit var retrofitServices: RetrofitServices

    override fun getPresenterInstance() = LoginPresenter(userSession, retrofitServices)

    @Test
    fun invalidEmailTest() {
        presenter.onLoginButtonClicked(INVALID_EMAIL, PASSWORD)
        verify(view, times(1)).showInvalidEmailError()
    }

    @Test
    fun invalidPasswordTest() {
        presenter.onLoginButtonClicked(EMAIL, INVALID_PASSWORD)
        verify(view, times(1)).showEmptyPasswordError()
    }

    @Test
    fun emptyEmailTest() {
        presenter.onLoginButtonClicked(EMPTY_EMAIL, PASSWORD)
        verify(view, times(1)).showEmptyEmailError()
    }

    @Test
    fun serviceSuccessfulRequest() {
        val authenticationService = AuthenticationServiceMock.successfulLogin()
        `when`(retrofitServices.getService(AuthenticationService::class.java)).thenReturn(authenticationService)

        presenter.onLoginButtonClicked(EMAIL, PASSWORD)

        verify(view, times(1)).goToHomeScreen()
    }

    @Test
    fun serviceInvalidEmailRequest() {
        val authenticationService = AuthenticationServiceMock.failedLogin()
        `when`(retrofitServices.getService(AuthenticationService::class.java)).thenReturn(authenticationService)
    }
}