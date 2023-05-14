package org.task3_1.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    public static String getRandomString(int minLength, int maxLength) {
        Random rand = new Random();
        char firstChar = '!';
        char lastChar = '~';
        List<String> result = new ArrayList<>();
        for (int i = 0; i < getRandomInt(minLength, maxLength); i++) {
            int randomCode = rand.nextInt(((int) lastChar - (int) firstChar) + 1) + (int) firstChar;
            result.add(String.valueOf((char) randomCode));
        }
        return String.join("",  result);
    }

    public static int getRandomInt(int min, int max) {
        if (min >= max) LogUtils.logError("Minimal and maximal length of random string are invalid!", new Throwable("Parameter error"));
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
