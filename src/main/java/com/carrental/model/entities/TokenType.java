package com.carrental.model.entities;

import java.util.Optional;

public enum TokenType {
    PASSWORD, AUTHORIZATION_CODE;

    public static Optional<TokenType> getOptionalTokenType(String tokenTypeString) {
        for (TokenType tokenType : TokenType.values()) {
            if (tokenType.toString().equalsIgnoreCase(tokenTypeString)) {
                return Optional.of(tokenType);
            }
        }
        return Optional.ofNullable(null);
    }
}