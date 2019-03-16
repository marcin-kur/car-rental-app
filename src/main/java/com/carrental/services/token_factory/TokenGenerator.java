package com.carrental.services.token_factory;

import com.carrental.model.entities.Token;
import com.carrental.services.string_generator.StringGenerator;
import com.carrental.services.utils.DateTimeUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TokenGenerator {
    private final StringGenerator stringGenerator;
    private final int tokenLength;
    private final int tokenTimespan;

    public TokenGenerator(StringGenerator stringGenerator, int tokenLength, int tokenTimespan) {
        this.stringGenerator = stringGenerator;
        this.tokenLength = tokenLength;
        this.tokenTimespan = tokenTimespan;
    }

    public Token generateToken() {
        return new Token(generateId(), generateExpirationTimestamp());
    }

    private String generateId() {
        return stringGenerator.generateString(tokenLength);
    }

    private LocalDateTime generateExpirationTimestamp() {
        return LocalDateTime.now().plus(tokenTimespan, ChronoUnit.SECONDS);
    }
}
