package ar.com.wolox.android.example.test.login

import ar.com.wolox.android.example.ui.login.LoginPresenter
import ar.com.wolox.android.example.ui.login.LoginView
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.tests.WolmoPresenterTest
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import org.mockito.Mock
import org.mockito.Mockito.times

class LoginPresenterTest : WolmoPresenterTest<LoginView, LoginPresenter>() {

    @Mock
    lateinit var userSession: UserSession

    @Mock
    lateinit var retrofitServices: RetrofitServices

    override fun getPresenterInstance() = LoginPresenter(userSession, retrofitServices)

    /*
    @Test
    fun `given an invalid email then an error is displayed`() {
        presenter.onLoginButtonClicked(INVALID_EMAIL, PASSWORD)
        verify(view, times(1)).showInvalidEmailError()
    }

    @Test
    fun `given an empty password then an error is displayed`() {
        presenter.onLoginButtonClicked(EMAIL, INVALID_PASSWORD)
        verify(view, times(1)).showEmptyPasswordError()
    }

    @Test
    fun `given an empty email then an error is displayed`() {
        presenter.onLoginButtonClicked(EMPTY_EMAIL, PASSWORD)
        verify(view, times(1)).showEmptyEmailError()
    }

    @Test
    fun `given correct credentials then the user is logged and redirected to the home screen`() {
        val authenticationService = AuthenticationServiceMock.successfulLogin()
        `when`(retrofitServices.getService(AuthenticationService::class.java)).thenReturn(authenticationService)
        presenter.onLoginButtonClicked(EMAIL, PASSWORD)
        verify(view, times(1)).goToHomeScreen()
    }

    @Test
    fun `given a wrong email then the user is not logged and a toast error message is displayed`() {
        val authenticationService = AuthenticationServiceMock.unsuccessfulLogin()
        `when`(retrofitServices.getService(AuthenticationService::class.java)).thenReturn(authenticationService)
        presenter.onLoginButtonClicked(WRONG_EMAIL, PASSWORD)
        verify(view, times(0)).goToHomeScreen()
        verify(view, times(1)).showCredentialsError()
    }

    @Test
    fun `given a correct email and a wrong password then the user is not logged and a toast message is displayed`() {
        val authenticationService = AuthenticationServiceMock.successfulLogin()
        `when`(retrofitServices.getService(AuthenticationService::class.java)).thenReturn(authenticationService)
        presenter.onLoginButtonClicked(EMAIL, WRONG_PASSWORD)
        verify(view, times(0)).goToHomeScreen()
        verify(view, times(1)).showCredentialsError()
    }
    */
}
