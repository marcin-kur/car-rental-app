package com.carrental.services.token_facade;

public class TokenCredentials {
    private String username;
    private String password;
    private String clientId;
    private String clientSecret;

    public TokenCredentials(String username, String password, String clientId, String clientSecret) {
        this.username = username;
        this.password = password;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
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
