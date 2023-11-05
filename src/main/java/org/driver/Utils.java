package org.driver;

import java.util.Random;

public class Utils {

    public static Integer getRandomIntFromZeroTo(int maxInt){
        Random random = new Random();
        return random.ints(0,maxInt).findFirst().getAsInt();
    }
}
