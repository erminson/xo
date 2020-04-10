package ru.erminson.xo.helpers;

public class CoordinateHelper {
    public static boolean checkCoordinate(final int x, final int maxSize) {
        return x >= 0 || x < maxSize;
    }
}
