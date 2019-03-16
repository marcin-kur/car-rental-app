package com.carrental.controllers;

import com.carrental.model.*;
import com.carrental.rest_wrappers.OrderRequest;
import com.carrental.services.request_handlers.RequestHandler;
import com.carrental.services.request_handlers.RequestHandlerOrder;
import com.carrental.services.request_handlers.RequestHandlerProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final TokenRepository tokenRepository;
    private final OrderRepository orderRepository;
    private final AddressRepository addressRepository;
    private final CarRepository carRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public OrderController(TokenRepository tokenRepository,
                           OrderRepository orderRepository,
                           AddressRepository addressRepository,
                           CarRepository carRepository,
                           ClientRepository clientRepository) {
        this.tokenRepository = tokenRepository;
        this.orderRepository = orderRepository;
        this.addressRepository = addressRepository;
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String getAll(@RequestHeader(value = "authorization") String authorizationCode, @RequestBody OrderRequest orderRequest) {
        RequestHandler requestHandlerClient = new RequestHandlerOrder(orderRepository, addressRepository, carRepository, clientRepository, orderRequest);
        RequestHandler requestHandlerProxy = new RequestHandlerProxy(requestHandlerClient, tokenRepository, authorizationCode);

        return requestHandlerProxy.handleRequest();
    }
}
