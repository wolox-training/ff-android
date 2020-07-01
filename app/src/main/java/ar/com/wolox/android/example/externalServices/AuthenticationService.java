package ar.com.wolox.android.example.externalServices;

import java.util.List;

import ar.com.wolox.android.example.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Authentication service
 */
public interface AuthenticationService {

    @GET("users")
    Call<List<User>> findUser(@Query("email") String email);
}
