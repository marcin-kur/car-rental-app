package com.carrental.services.string_generator;

import java.util.Random;

public class PlainJavaStringGenerator implements StringGenerator {

    private final Random random;

    public PlainJavaStringGenerator(Random random) {
        this.random = random;
    }

    @Override
    public String generateString(int length) {
        int leftLimit = 48;
        int rightLimit = 90;
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            builder.append((char) randomInt);
        }
        return builder.toString();
    }
}
