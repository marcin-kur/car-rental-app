package com.carrental.services.commands;

import com.carrental.exceptions.CreateOrderException;
import com.carrental.model.entities.Order;

import java.time.LocalDate;
import java.util.Optional;

public class AddStartDateCommand implements Command {

    private Order order;
    private LocalDate startDate;

    public AddStartDateCommand(Order order, LocalDate startDate) {
        this.order = order;
        this.startDate = startDate;
    }

    @Override
    public void execute() {
        order.setStartDate(Optional.ofNullable(startDate).orElseThrow(() -> new CreateOrderException("Invalid start date")));
    }
}
