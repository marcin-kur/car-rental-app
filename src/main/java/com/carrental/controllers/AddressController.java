package com.carrental.controllers;

import com.carrental.model.AddressRepository;
import com.carrental.model.TokenRepository;
import com.carrental.services.request_handlers.RequestHandler;
import com.carrental.services.request_handlers.RequestHandlerAddress;
import com.carrental.services.request_handlers.RequestHandlerCar;
import com.carrental.services.request_handlers.RequestHandlerProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/addresses")
public class AddressController {

    private final AddressRepository addressRepository;
    private final TokenRepository tokenRepository;

    @Autowired
    public AddressController(AddressRepository addressRepository, TokenRepository tokenRepository) {
        this.addressRepository = addressRepository;
        this.tokenRepository = tokenRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(@RequestHeader(value = "Authorization") String authorizationCode) {
        RequestHandler requestHandlerAddress = new RequestHandlerAddress(addressRepository);
        RequestHandler requestHandlerProxy = new RequestHandlerProxy(requestHandlerAddress, tokenRepository, authorizationCode);

        return requestHandlerProxy.handleRequest();
    }
}
