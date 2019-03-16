package com.carrental.rest_wrappers;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TokenResponse {

    private String token;
    private long expiresIn;

    public TokenResponse() {}

    public TokenResponse(String token, LocalDateTime expiresIn) {
        this.token = token;
        this.expiresIn = getExpiresIn(expiresIn);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    private long getExpiresIn(LocalDateTime expiresIn) {
        return LocalDateTime.now().until(expiresIn, ChronoUnit.SECONDS);
    }
}