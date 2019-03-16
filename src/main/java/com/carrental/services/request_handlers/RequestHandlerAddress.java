package com.carrental.services.request_handlers;

import com.carrental.model.AddressRepository;
import com.google.gson.Gson;

public class RequestHandlerAddress implements RequestHandler {

    private final AddressRepository addressRepository;

    public RequestHandlerAddress(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public String handleRequest() {
        return new Gson().toJson(addressRepository.findAll());
    }
}
