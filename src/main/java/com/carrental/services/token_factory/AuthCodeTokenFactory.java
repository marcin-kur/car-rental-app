package com.carrental.services.token_factory;

import com.carrental.services.string_generator.StreamStringGenerator;
import com.carrental.services.string_generator.StringGenerator;

import java.util.Random;

public class AuthCodeTokenFactory extends AbstractTokenFactory {
    @Override
    public TokenValidator createTokenValidator() {
        return new AuthCodeTokenValidator();
    }

    @Override
    public TokenGenerator createTokenGenerator() {
        StringGenerator stringGenerator = new StreamStringGenerator(new Random());
        int tokenLength = 40;
        int tokenTimespan = 3600;
        return new TokenGenerator(stringGenerator, tokenLength, tokenTimespan);
    }
}
