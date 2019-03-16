package com.carrental.rest_wrappers;

public class TokenRequest {
    private String type;
    private String username;
    private String password;
    private String clientId;
    private String clientSecret;

    public String getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}