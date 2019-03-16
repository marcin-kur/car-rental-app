package com.carrental.model;

import com.carrental.model.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    Optional<Token> findByExpirationDateAfterAndId(@Param("expiration_date") LocalDateTime expirationDate, @Param("id") String id);
}
