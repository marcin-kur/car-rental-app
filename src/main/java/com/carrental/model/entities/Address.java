package com.carrental.model.entities;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Address {

    @Id
    @Column(name = "id")
    @Getter
    private Long id;

    @Column(name = "street_address")
    @Getter
    private String streetAddress;

    @Column(name = "city")
    @Getter
    private String city;

    @Column(name = "country")
    @Enumerated(EnumType.STRING)
    @Getter
    private Country country;
}
