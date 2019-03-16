package com.carrental.services.discount_calculator;

import com.carrental.model.entities.Order;

public class DiscountCalculator {

    private Discount discount;
    private Order order;

    public DiscountCalculator(Order order) {
        this.order = order;
        this.discount = createDiscounts();
    }

    private Discount createDiscounts() {
        ElectricCarDiscount electricCarDiscount = new ElectricCarDiscount(order);
        LongRentalDiscount longRentalDiscount = new LongRentalDiscount(order);
        PolandLocatedDiscount polandLocatedDiscount = new PolandLocatedDiscount(order);
        FastSportCarDiscount fastSportCarDiscount = new FastSportCarDiscount(order);

        electricCarDiscount.setNextDiscount(longRentalDiscount);
        longRentalDiscount.setNextDiscount(polandLocatedDiscount);
        polandLocatedDiscount.setNextDiscount(fastSportCarDiscount);

        return electricCarDiscount;
    }

    public double calculate() {
        return discount.add();
    }
}
