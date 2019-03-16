package com.carrental.services.token_factory;

import com.carrental.model.ClientRepository;
import com.carrental.model.entities.Client;
import com.carrental.services.token_facade.TokenCredentials;

import java.util.Optional;

public class PasswordTokenValidator extends TokenValidator {
    @Override
    public boolean validateCredentials(ClientRepository clientRepository, TokenCredentials tokenCredentials) {
        Optional<Client> clientOptional = clientRepository.findByNameAndPassword(
                tokenCredentials.getUsername(), tokenCredentials.getPassword());
        return clientOptional.isPresent();
    }
}
