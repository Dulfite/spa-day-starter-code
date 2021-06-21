package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotBlank(message = "Username is required")
    @Size(min = 5, max = 15, message = "Username must be 5-15 characters.")
    private String username;

    @Email(message = "Invalid email, please try again.")
    private String email;

    @NotBlank(message = "Password required.")
    @Size(min = 6, message = "Password must be 6 characters minimum.")
    private String password;

    @NotNull(message = "Passwords don't match.")
    @NotBlank(message = "Enter password again.")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password, String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword() {
        if (password != null && verifyPassword != null && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }
    }
}
