package com.carrental.services.commands;

import com.carrental.exceptions.CreateOrderException;
import com.carrental.model.entities.Order;

import java.time.LocalDate;
import java.util.Optional;

public class AddEndDateCommand implements Command {

    private Order order;
    private LocalDate endDate;

    public AddEndDateCommand(Order order, LocalDate endDate) {
        this.order = order;
        this.endDate = endDate;
    }

    @Override
    public void execute() {
        order.setEndDate(Optional.ofNullable(endDate).orElseThrow(() -> new CreateOrderException("Invalid start date")));
    }

}
