package com.carrental.services.discount_calculator;

import com.carrental.model.entities.Classification;
import com.carrental.model.entities.Order;

public class FastSportCarDiscount extends Discount {

    private final double discountPercentage = 0.1;
    private final double carPower = 400;

    public FastSportCarDiscount(Order order) {
        super(order);
    }

    @Override
    boolean isToApply() {
        return order.getCar().getClassification() == Classification.SPORT
                && order.getCar().getPower() > carPower;
    }

    @Override
    double calculate() {
        return order.getBasePrice() * discountPercentage;
    }
}
