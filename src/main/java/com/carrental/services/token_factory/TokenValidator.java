package com.carrental.services.token_factory;

import com.carrental.model.ClientRepository;
import com.carrental.services.token_facade.TokenCredentials;

public abstract class TokenValidator {
    public abstract boolean validateCredentials(ClientRepository clientRepository, TokenCredentials tokenCredentials);
}
