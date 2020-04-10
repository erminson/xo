package ru.erminson.xo.models;

public class Player {
    private final String name;
    private final String figure;

    Player(final PlayerBuilder playerBuilder) {
        this.name = playerBuilder.getName();
        this.figure = playerBuilder.getFigure();
    }

    public String getName() {
        return this.name;
    }

    public String getFigure() {
        return this.figure;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", figure='" + figure + '\'' +
                '}';
    }
}
