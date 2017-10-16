package com.ardhiart.datasiswa.API.Model;

/**
 * Created by Hinata on 10/16/2017.
 */
public class LoginRequest {
    String username = "";
    String password = "";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
