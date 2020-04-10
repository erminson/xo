package ru.erminson.xo.models;

public class Game {
    private static final String GAME_NAME = "XO";
    private Player[] players;

    public String getGameName() {
        return Game.GAME_NAME;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player currentPlayer() {
        return null;
    }

    public boolean move(final int x, final int y) {
        return false;
    }
}
