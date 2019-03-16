package com.carrental.services.discount_calculator;

import com.carrental.model.entities.Country;
import com.carrental.model.entities.Order;

public class PolandLocatedDiscount extends Discount {

    private final double discountValue = 30;

    public PolandLocatedDiscount(Order order) {
        super(order);
    }

    @Override
    boolean isToApply() {
        return order.getAddress().getCountry() == Country.POLAND;
    }

    @Override
    double calculate() {
        return discountValue;
    }
}