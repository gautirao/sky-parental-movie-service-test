package com.sky.video.streaming.services.utitilty;

public class MovieHelper {

    public static int getParentalControlLevelValue(String parentalControlLevel) {
        switch (parentalControlLevel) {
            case "U":
                return 1;
            case "PG":
                return 2;
            case "12":
                return 3;
            case "15":
                return 4;
            case "18":
                return 5;
            default:
                throw new IllegalArgumentException("Invalid Parental Control Level Supplied ");
        }

    }
}
