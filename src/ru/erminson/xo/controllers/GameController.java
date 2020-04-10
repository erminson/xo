package ru.erminson.xo.controllers;

public class GameController {
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = 3;

    private final String gameName;

    public GameController(String gameName) {
        this.gameName = gameName;
    }

    public boolean move(final int x, final int y) {
        assert x >= 0;
        assert y >= 0;

        // TODO
        return checkCoordinate(x) && checkCoordinate(y);
    }

    private static boolean checkCoordinate(final int coordinate) {
        return coordinate < MIN_COORDINATE || coordinate >= MAX_COORDINATE;
    }
}
