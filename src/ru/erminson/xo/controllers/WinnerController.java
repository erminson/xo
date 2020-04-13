package ru.erminson.xo.controllers;

import ru.erminson.xo.models.Field;
import ru.erminson.xo.models.Figure;
import ru.erminson.xo.models.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {
    public Figure getWinner(final Field field) {

        try {
            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(i, 0), new IPointChanger() {
                    @Override
                    public Point next(Point point) {
                        return new Point(point.x, point.y + 1);
                    }
                })) {
                    return field.getFigure(new Point(i, 0));
                }
            }

            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(0, i), new IPointChanger() {
                    @Override
                    public Point next(Point point) {
                        return new Point(point.x + 1, point.y);
                    }
                })) {
                    return field.getFigure(new Point(0, i));
                }
            }

            if (check(field, new Point(0, 0), new IPointChanger() {
                @Override
                public Point next(Point point) {
                    return new Point(point.x + 1, point.y + 1);
                }
            })) {
                return field.getFigure(new Point(0, 0));
            }

            if (check(field, new Point(0, 2), new IPointChanger() {
                @Override
                public Point next(Point point) {
                    return new Point(point.x + 1, point.y - 1);
                }
            })) {
                return field.getFigure(new Point(1, 1));
            }
        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }


        return null;
    }

    private boolean check(final Field field, final Point startPoint, final IPointChanger pointChanger) {
        final Point p1 = startPoint;
        final Point p2 = pointChanger.next(p1);
        final Point p3 = pointChanger.next(p2);

        try {
            if (field.getFigure(p1) == null) {
                return false;
            }
            if (field.getFigure(p1) == field.getFigure(p2) &&
                    field.getFigure(p1) == field.getFigure(p3)) {
                return true;
            }
        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }

        return false;
    }

    private interface IPointChanger {
        Point next(final Point point);
    }
}
