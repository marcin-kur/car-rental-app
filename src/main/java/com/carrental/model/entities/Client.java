package com.carrental.model.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Client {

    @Id
    @Column(name = "name")
    @Getter
    private String name;

    @Column(name = "password")
    @Getter
    private String password;

    @Column(name = "client_id")
    @Getter
    private String clientId;

    @Column(name = "client_secret")
    @Getter
    private String clientSecret;
}