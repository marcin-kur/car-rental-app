package com.carrental.services.request_handlers;

import com.carrental.model.ClientRepository;
import com.google.gson.Gson;

public class RequestHandlerClient implements RequestHandler {

    private final ClientRepository clientRepository;

    public RequestHandlerClient(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public String handleRequest() {
        return new Gson().toJson(clientRepository.findAll());
    }
}
