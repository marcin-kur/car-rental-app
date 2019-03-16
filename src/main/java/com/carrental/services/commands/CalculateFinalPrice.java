package com.carrental.services.commands;

import com.carrental.model.entities.Order;

public class CalculateFinalPrice implements Command {

    private Order order;

    public CalculateFinalPrice(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.setFinalPrice(order.getBasePrice() - order.getDiscount());
    }
}
