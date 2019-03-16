package com.carrental.services.commands;

import com.carrental.model.OrderRepository;
import com.carrental.model.entities.Order;

public class SaveOrderCommand implements Command {

    private Order order;
    private OrderRepository orderRepository;

    public SaveOrderCommand(Order order, OrderRepository orderRepository) {
        this.order = order;
        this.orderRepository = orderRepository;
    }

    @Override
    public void execute() {
        orderRepository.save(order);
    }
}
