package com.carrental.services.discount_calculator;

import com.carrental.model.entities.FuelType;
import com.carrental.model.entities.Order;

public class ElectricCarDiscount extends Discount {

    private final double discountPercentage = 0.05;

    public ElectricCarDiscount(Order order) {
        super(order);
    }

    @Override
    boolean isToApply() {
        return order.getCar().getFuelType() == FuelType.ELECTRIC;
    }

    @Override
    double calculate() {
        return order.getBasePrice() * discountPercentage;
    }
}
