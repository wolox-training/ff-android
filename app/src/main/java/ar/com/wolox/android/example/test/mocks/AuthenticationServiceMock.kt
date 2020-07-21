package ar.com.wolox.android.example.test.mocks

import ar.com.wolox.android.example.externalServices.AuthenticationService
import ar.com.wolox.android.example.model.User
import ar.com.wolox.android.example.utils.Extras.AuthenticationCredentials.EMAIL
import ar.com.wolox.android.example.utils.Extras.AuthenticationCredentials.PASSWORD
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthenticationServiceMock {

    companion object {
        private fun successfulResponse(): List<User> = listOf(User(EMAIL, PASSWORD))

        fun successfulLogin(): AuthenticationService {
            val describedService = mock(AuthenticationService::class.java)
            val mockedCall = performMockedCall(successfulResponse())
            `when`(describedService.findUser(EMAIL)).thenReturn(mockedCall)
            return describedService
        }

        fun failedLogin() : List<User> = emptyList()

        private fun performMockedCall(response: List<User>): Call<List<User>> {
            val call: Call<List<User>> = mock(Call::class.java) as Call<List<User>>
            val mockedResponse = mock(Response::class.java) as Response<List<User>>
            `when`(mockedResponse.body()).thenReturn(response)
            `when`(call.enqueue(any())).thenAnswer() {
                (it.getArgument(0) as Callback<List<User>>).onResponse(call, mockedResponse)
            }
            return call
        }
    }
}