package com.carrental.services.request_handlers;

import com.carrental.model.AddressRepository;
import com.carrental.model.CarRepository;
import com.carrental.model.ClientRepository;
import com.carrental.model.OrderRepository;
import com.carrental.model.entities.Order;
import com.carrental.rest_wrappers.OrderRequest;
import com.carrental.rest_wrappers.OrderResponse;
import com.carrental.services.commands.*;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class RequestHandlerOrder implements RequestHandler {

    private final OrderRepository orderRepository;
    private final AddressRepository addressRepository;
    private final CarRepository carRepository;
    private final ClientRepository clientRepository;
    private final OrderRequest orderRequest;

    private Order order;
    private List<Command> createOrderCommands;

    public RequestHandlerOrder(OrderRepository orderRepository, AddressRepository addressRepository, CarRepository carRepository, ClientRepository clientRepository, OrderRequest orderRequest) {
        this.orderRepository = orderRepository;
        this.addressRepository = addressRepository;
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
        this.orderRequest = orderRequest;
        this.order = new Order();
    }

    @Override
    public String handleRequest() {
        setCreateOrderCommands();
        runCreateOrderCommands();
        return new Gson().toJson(new OrderResponse(order));
    }

    private void runCreateOrderCommands() {
        createOrderCommands.forEach(Command::execute);
    }

    private void setCreateOrderCommands() {
        createOrderCommands = Arrays.asList(
                new AddAddressCommand(order, addressRepository, orderRequest.getAddressId()),
                new AddCarCommand(order, carRepository, orderRequest.getCarId()),
                new AddClientCommand(order, clientRepository, orderRequest.getClientName()),
                new AddStartDateCommand(order, orderRequest.getStartDate()),
                new AddEndDateCommand(order, orderRequest.getEndDate()),
                new ValidateRangeCommand(order),
                new CalculateBasePrice(order),
                new CalculateDiscountCommand(order),
                new CalculateFinalPrice(order),
                new SaveOrderCommand(order, orderRepository)
        );
    }
}
