package ar.com.wolox.android.example.model;

import androidx.annotation.NonNull;

/**
 * Basic user model
 */
public class User {

    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @NonNull
    public String getEmail() {
        return this.email;
    }

    @NonNull
    public String getPassword() {
        return this.password;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
}
