package com.carrental.services.token_factory;

import com.carrental.services.string_generator.PlainJavaStringGenerator;
import com.carrental.services.string_generator.StringGenerator;

import java.util.Random;

public class PasswordTokenFactory extends AbstractTokenFactory {
    @Override
    public TokenValidator createTokenValidator() {
        return new PasswordTokenValidator();
    }

    @Override
    public TokenGenerator createTokenGenerator() {
        StringGenerator stringGenerator = new PlainJavaStringGenerator(new Random());
        int tokenLength = 20;
        int tokenTimespan = 1800;
        return new TokenGenerator(stringGenerator, tokenLength, tokenTimespan);
    }
}
