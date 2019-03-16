package com.carrental.services.token_facade;

import com.carrental.exceptions.CredentialsException;
import com.carrental.exceptions.TokenTypeException;
import com.carrental.rest_wrappers.TokenRequest;
import com.carrental.model.ClientRepository;
import com.carrental.model.entities.Token;
import com.carrental.model.entities.TokenType;
import com.carrental.services.token_factory.AbstractTokenFactory;
import com.carrental.services.token_factory.TokenGenerator;
import com.carrental.services.token_factory.TokenValidator;

import java.util.Optional;

public class TokenCreatorFacade {

    private final TokenRequest tokenRequest;
    private final ClientRepository clientRepository;

    public TokenCreatorFacade(ClientRepository clientRepository, TokenRequest tokenRequest) {
        this.tokenRequest = tokenRequest;
        this.clientRepository = clientRepository;
    }

    public Token createToken() throws TokenTypeException, CredentialsException {
        TokenType tokenType = TokenType.getOptionalTokenType(tokenRequest.getType())
                .orElseThrow(() -> new TokenTypeException("Invalid token type"));
        AbstractTokenFactory tokenFactory = AbstractTokenFactory.getTokenFactory(tokenType)
                .orElseThrow(() -> new TokenTypeException("Invalid token type"));

        TokenValidator tokenValidator = tokenFactory.createTokenValidator();
        TokenGenerator tokenGenerator = tokenFactory.createTokenGenerator();

        Optional<Token> tokenOptional = Optional.ofNullable(null);
        if (tokenValidator.validateCredentials(clientRepository, getTokenCredentials(tokenRequest))) {
            tokenOptional = Optional.of(tokenGenerator.generateToken());
        }

        return tokenOptional.orElseThrow(() -> new CredentialsException("Invalid credentials"));
    }

    private TokenCredentials getTokenCredentials(TokenRequest tokenRequest) {
        return new TokenCredentials(
                tokenRequest.getUsername(),
                tokenRequest.getPassword(),
                tokenRequest.getClientId(),
                tokenRequest.getClientSecret());
    }
}
