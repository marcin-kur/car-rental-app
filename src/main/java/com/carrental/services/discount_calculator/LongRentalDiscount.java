package com.carrental.services.discount_calculator;

import com.carrental.model.entities.Order;

import java.time.temporal.ChronoUnit;

public class LongRentalDiscount extends Discount {

    private final double discountPercentage = 0.07;
    private final long rentalPeriod = 10;

    public LongRentalDiscount(Order order) {
        super(order);
    }

    @Override
    boolean isToApply() {
        return order.getStartDate().until(order.getEndDate(), ChronoUnit.DAYS) > rentalPeriod;
    }

    @Override
    double calculate() {
        return order.getBasePrice() * discountPercentage;
    }
}
