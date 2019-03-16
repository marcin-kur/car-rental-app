package com.carrental.services.commands;

import com.carrental.model.entities.Order;

import java.time.temporal.ChronoUnit;

public class CalculateBasePrice implements Command {

    private Order order;

    public CalculateBasePrice(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        double carPrice = order.getCar().getPrice();
        long orderPeriod = order.getStartDate().until(order.getEndDate(), ChronoUnit.DAYS);

        order.setBasePrice(carPrice * orderPeriod);
    }
}
