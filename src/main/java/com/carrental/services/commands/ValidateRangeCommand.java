package com.carrental.services.commands;

import com.carrental.exceptions.CreateOrderException;
import com.carrental.model.entities.Order;

import java.time.LocalDate;

public class ValidateRangeCommand implements Command {

    private Order order;

    public ValidateRangeCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        if (order.getStartDate().isBefore(LocalDate.now()) ||
                order.getStartDate().isAfter(order.getEndDate())) {
            throw new CreateOrderException("Start date can't be after end date");
        }
    }
}
