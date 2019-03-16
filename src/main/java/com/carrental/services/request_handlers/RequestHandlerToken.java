package com.carrental.services.request_handlers;

import com.carrental.model.ClientRepository;
import com.carrental.model.TokenRepository;
import com.carrental.model.entities.Token;
import com.carrental.rest_wrappers.TokenRequest;
import com.carrental.rest_wrappers.TokenResponse;
import com.carrental.services.token_facade.TokenCreatorFacade;
import com.google.gson.Gson;

public class RequestHandlerToken implements RequestHandler {

    private final TokenRepository tokenRepository;
    private final ClientRepository clientRepository;
    private final TokenRequest tokenRequest;

    public RequestHandlerToken(TokenRepository tokenRepository, ClientRepository clientRepository, TokenRequest tokenRequest) {
        this.tokenRepository = tokenRepository;
        this.clientRepository = clientRepository;
        this.tokenRequest = tokenRequest;
    }

    @Override
    public String handleRequest() {
        TokenCreatorFacade tokenCreatorFacade = new TokenCreatorFacade(clientRepository, tokenRequest);
        Token token = tokenCreatorFacade.createToken();
        tokenRepository.save(token);

        return new Gson().toJson(new TokenResponse(token.getId(), token.getExpirationDate()));
    }
}
