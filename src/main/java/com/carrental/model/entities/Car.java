package com.carrental.model.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "car")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Car {

    @Id
    @Column(name = "id")
    @Getter
    private Long id;

    @Column(name = "name")
    @Getter
    private String name;

    @Column(name = "price")
    @Getter
    private double price;

    @Column(name = "fuel_type")
    @Enumerated(EnumType.STRING)
    @Getter
    private FuelType fuelType;

    @Column(name = "power")
    @Getter
    private double power;

    @Column(name = "classification")
    @Enumerated(EnumType.STRING)
    @Getter
    private Classification classification;
}
