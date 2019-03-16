package com.carrental.controllers;

import com.carrental.model.TokenRepository;
import com.carrental.model.ClientRepository;
import com.carrental.services.request_handlers.RequestHandler;
import com.carrental.services.request_handlers.RequestHandlerClient;
import com.carrental.services.request_handlers.RequestHandlerProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;
    private final TokenRepository tokenRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository, TokenRepository tokenRepository) {
        this.clientRepository = clientRepository;
        this.tokenRepository = tokenRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(@RequestHeader(value = "authorization") String authorizationCode) {
        RequestHandler requestHandlerClient = new RequestHandlerClient(clientRepository);
        RequestHandler requestHandlerProxy = new RequestHandlerProxy(requestHandlerClient, tokenRepository, authorizationCode);

        return requestHandlerProxy.handleRequest();
    }
}