package com.carrental.services.request_handlers;

import com.carrental.model.CarRepository;
import com.google.gson.Gson;

public class RequestHandlerCar implements RequestHandler {

    private final CarRepository carRepository;

    public RequestHandlerCar(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public String handleRequest() {
        return new Gson().toJson(carRepository.findAll());
    }
}
