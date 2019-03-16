package com.carrental.controllers;

import com.carrental.model.CarRepository;
import com.carrental.model.TokenRepository;
import com.carrental.services.request_handlers.RequestHandler;
import com.carrental.services.request_handlers.RequestHandlerCar;
import com.carrental.services.request_handlers.RequestHandlerProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarRepository carRepository;
    private final TokenRepository tokenRepository;

    @Autowired
    public CarController(CarRepository carRepository, TokenRepository tokenRepository) {
        this.carRepository = carRepository;
        this.tokenRepository = tokenRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(@RequestHeader(value = "Authorization") String authorizationCode) {
        RequestHandler requestHandlerCar = new RequestHandlerCar(carRepository);
        RequestHandler requestHandlerProxy = new RequestHandlerProxy(requestHandlerCar, tokenRepository, authorizationCode);

        return requestHandlerProxy.handleRequest();
    }
}
