package com.carrental.model.entities;

import com.carrental.services.utils.LocalDateConverter;
import com.carrental.services.utils.LocalDateTimeConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "quote")
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue
    @Getter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @Getter @Setter
    private Address address;

    @ManyToOne
    @JoinColumn(name = "client_name")
    @Getter @Setter
    private Client client;

    @ManyToOne
    @JoinColumn(name = "car_id")
    @Getter @Setter
    private Car car;

    @Column(name = "base_price")
    @Getter @Setter
    private double basePrice;

    @Column(name = "discount")
    @Getter @Setter
    private double discount;

    @Column(name = "final_price")
    @Getter @Setter
    private double finalPrice;

    @Column(name = "start_date")
    @Convert(converter = LocalDateConverter.class)
    @Getter @Setter
    private LocalDate startDate;

    @Column(name = "end_date")
    @Convert(converter = LocalDateConverter.class)
    @Getter @Setter
    private LocalDate endDate;
}
