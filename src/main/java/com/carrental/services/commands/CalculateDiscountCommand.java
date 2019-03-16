package com.carrental.services.commands;

import com.carrental.model.entities.Order;
import com.carrental.services.discount_calculator.DiscountCalculator;

public class CalculateDiscountCommand implements Command {

    private Order order;

    public CalculateDiscountCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        DiscountCalculator discountCalculator = new DiscountCalculator(order);
        order.setDiscount(discountCalculator.calculate());
    }
}
