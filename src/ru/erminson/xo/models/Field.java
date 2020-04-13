package ru.erminson.xo.models;

import ru.erminson.xo.models.exceptions.InvalidPointException;

import java.awt.*;

public class Field {
    private static final int MIN_COORDINATE = 0;

    private final int fieldSize;
    private final Figure[][] figures;// = new Figure[FIELD_SIZE][FIELD_SIZE];

    public Field(final int fieldSize) {
        this.fieldSize = fieldSize;
        this.figures = new Figure[fieldSize][fieldSize];
    }


    public int getSize() {
        return this.fieldSize;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!isValidPoint(point)) {
            throw new InvalidPointException();
        }

        return figures[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!isValidPoint(point)) {
            throw new InvalidPointException();
        }

        figures[point.x][point.y] = figure;
    }

    private boolean isValidPoint(final Point point) {
        return isValidCoordinate(point.x) && isValidCoordinate(point.y);
    }

    private boolean isValidCoordinate(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < figures.length;
    }
}
