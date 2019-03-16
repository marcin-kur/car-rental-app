package com.carrental.rest_wrappers;

import com.carrental.model.entities.Address;
import com.carrental.model.entities.Car;
import com.carrental.model.entities.Order;

import java.time.LocalDate;

public class OrderResponse {

    private long orderId;
    private Car car;
    private Address address;
    private String clientName;
    private double basePrice;
    private double discount;
    private double finalPrice;
    private LocalDate startDate;
    private LocalDate endDate;

    public OrderResponse(Order order) {
        this.orderId = order.getId();
        this.car = order.getCar();
        this.address = order.getAddress();
        this.clientName = order.getClient().getName();
        this.basePrice = order.getBasePrice();
        this.discount = order.getDiscount();
        this.finalPrice = order.getFinalPrice();
        this.startDate = order.getStartDate();
        this.endDate = order.getEndDate();
    }
}
