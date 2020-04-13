package ru.erminson.xo.controllers;

import ru.erminson.xo.models.Field;
import ru.erminson.xo.models.Figure;
import ru.erminson.xo.models.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {
    public Figure currentMove(final Field field) {
        int countFigure = 0;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                try {
                    if (field.getFigure(new Point(i, j)) != null) {
                        countFigure += 1;
                    }
                } catch (final InvalidPointException e) {
                    e.printStackTrace();
                }
            }
        }

        if (countFigure == field.getSize() * field.getSize()) {
            return null;
        }

        if (countFigure % 2 == 0) {
            return Figure.X;
        }

        return Figure.O;
    }
}
