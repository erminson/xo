package ru.erminson.xo.models;

public class Player {
    private final String name;
    private final Figure figure;

    Player(final String name, final Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public String getName() {
        return this.name;
    }

    public Figure getFigure() {
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
