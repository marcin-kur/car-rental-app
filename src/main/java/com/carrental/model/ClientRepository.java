package com.carrental.model;

import com.carrental.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, String> {

    Optional<Client> findByNameAndPassword(String name, String password);

    Optional<Client> findByClientIdAndClientSecret(String clientId, String clientSecret);

    Optional<Client> findByName(String name);
}