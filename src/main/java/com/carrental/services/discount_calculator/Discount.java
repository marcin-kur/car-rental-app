package com.carrental.services.discount_calculator;

import com.carrental.model.entities.Order;

public abstract class Discount {

    protected final Order order;
    private Discount nextDiscount;

    public Discount(Order order) {
        this.order = order;
    }

    public double add() {
        double discountAmount = isToApply()
                ? calculate()
                : 0D;

        return nextDiscount != null
                ? discountAmount + nextDiscount.add()
                : discountAmount;
    }

    public void setNextDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    abstract boolean isToApply();

    abstract double calculate();
}
