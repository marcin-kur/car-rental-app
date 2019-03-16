package com.carrental.services.string_generator;

import java.util.Random;

public class StreamStringGenerator implements StringGenerator {

    private final Random random;

    public StreamStringGenerator(Random random) {
        this.random = random;
    }

    @Override
    public String generateString(int length) {
        return random.ints(48, 122)
                .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
