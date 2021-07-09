package com.mitrais.bootcamp.atm.util;

import java.util.Random;

public class StringUtil {
    public static String generateRandomNumber() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        return String.format("%06d", number);
    }
}
