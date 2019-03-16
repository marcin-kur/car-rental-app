package com.carrental.controllers;

import com.carrental.model.ClientRepository;
import com.carrental.rest_wrappers.TokenRequest;
import com.carrental.model.TokenRepository;
import com.carrental.services.request_handlers.RequestHandler;
import com.carrental.services.request_handlers.RequestHandlerToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {
    private final TokenRepository tokenRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public TokenController(TokenRepository tokenRepository, ClientRepository clientRepository) {
        this.tokenRepository = tokenRepository;
        this.clientRepository = clientRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String getToken(@RequestBody TokenRequest tokenRequest) {
        RequestHandler requestHandlerToken = new RequestHandlerToken(tokenRepository, clientRepository, tokenRequest);
        return requestHandlerToken.handleRequest();
    }
}