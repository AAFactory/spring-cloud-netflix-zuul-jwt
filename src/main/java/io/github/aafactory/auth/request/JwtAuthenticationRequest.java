package io.github.aafactory.auth.request;

import java.io.Serializable;

public class  JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -8445942338965154778L;

    private String username;

    private String email;

    private String phone;

    private String password;

    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String username , String email, String phone , String password) {
        this.setUsername(username);
        this.setEmail(email);
        this.setPhone(phone);
        this.setPassword(password);
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
