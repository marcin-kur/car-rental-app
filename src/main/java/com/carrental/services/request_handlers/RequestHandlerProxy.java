package com.carrental.services.request_handlers;

import com.carrental.exceptions.CredentialsException;
import com.carrental.model.TokenRepository;
import com.carrental.model.entities.Token;

import java.time.LocalDateTime;
import java.util.Optional;

public class RequestHandlerProxy implements RequestHandler {

    private final RequestHandler requestHandler;
    private final TokenRepository tokenRepository;
    private final String authorizationCode;

    public RequestHandlerProxy(RequestHandler requestHandler, TokenRepository tokenRepository, String authorizationCode) {
        this.requestHandler = requestHandler;
        this.tokenRepository = tokenRepository;
        this.authorizationCode = authorizationCode;
    }

    @Override
    public String handleRequest() {
        if (isAuthorizationCodeValid()) {
            return requestHandler.handleRequest();
        }
        throw new CredentialsException("Invalid authorization token");
    }

    private boolean isAuthorizationCodeValid() {
        Optional<Token> tokenOptional = tokenRepository.findByExpirationDateAfterAndId(
                LocalDateTime.now(),
                authorizationCode);

        return tokenOptional.isPresent();
    }
}
