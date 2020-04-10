package ru.erminson.xo.models;

public enum Figure {
    X("X"),
    O("O");

    private final String figure;

    Figure(final String figure) {
        assert figure != null;

        this.figure = figure;
    }

    public String getFigure() {
        return this.figure;
    }

    @Override
    public String toString() {
        return this.figure;
    }
}
