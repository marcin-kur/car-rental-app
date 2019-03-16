package com.carrental.services.token_factory;

import com.carrental.model.ClientRepository;
import com.carrental.model.entities.Client;
import com.carrental.services.token_facade.TokenCredentials;

import java.util.Optional;

public class AuthCodeTokenValidator extends TokenValidator {
    @Override
    public boolean validateCredentials(ClientRepository clientRepository, TokenCredentials tokenCredentials) {
        Optional<Client> clientOptional = clientRepository.findByClientIdAndClientSecret(
                tokenCredentials.getClientId(),
                tokenCredentials.getClientSecret());

        return clientOptional.isPresent();
    }
}
