package ru.erminson.xo.controllers;

import ru.erminson.xo.models.Field;
import ru.erminson.xo.models.Figure;
import ru.erminson.xo.models.exceptions.AlreadyOccupiedException;
import ru.erminson.xo.models.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {
    public void applyFigure(final Field field,
                            final Figure figure,
                            final Point point) throws InvalidPointException, AlreadyOccupiedException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }
}
