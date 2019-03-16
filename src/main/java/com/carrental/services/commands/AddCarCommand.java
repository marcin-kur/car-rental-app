package com.carrental.services.commands;

import com.carrental.exceptions.CreateOrderException;
import com.carrental.model.CarRepository;
import com.carrental.model.entities.Car;
import com.carrental.model.entities.Order;

import java.util.Optional;

public class AddCarCommand implements Command {

    private Order order;
    private CarRepository carRepository;
    private long carId;

    public AddCarCommand(Order order, CarRepository carRepository, long carId) {
        this.order = order;
        this.carRepository = carRepository;
        this.carId = carId;
    }

    @Override
    public void execute() {
        Optional<Car> carOptional = carRepository.findById(carId);
        order.setCar(carOptional.orElseThrow(() -> new CreateOrderException("Invalid car id")));
    }
}
