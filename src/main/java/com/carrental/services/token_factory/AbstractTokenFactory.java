package com.carrental.services.token_factory;

import com.carrental.model.entities.TokenType;

import java.util.Optional;

public abstract class AbstractTokenFactory {

    public static Optional<AbstractTokenFactory> getTokenFactory(TokenType tokenType) {
        switch (tokenType) {
            case AUTHORIZATION_CODE:
                return Optional.of(new AuthCodeTokenFactory());
            case PASSWORD:
                return Optional.of(new PasswordTokenFactory());
            default:
                return Optional.ofNullable(null);
        }
    }

    public abstract TokenValidator createTokenValidator();

    public abstract TokenGenerator createTokenGenerator();
}
