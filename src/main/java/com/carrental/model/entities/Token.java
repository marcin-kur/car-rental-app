package com.carrental.model.entities;

import com.carrental.services.utils.LocalDateTimeConverter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "token")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Token {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "expiration_date")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime expirationDate;

    public Token(String id, LocalDateTime expirationDate) {
        this.id = id;
        this.expirationDate = expirationDate;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }
}
