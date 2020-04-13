package ru.erminson.xo.models;

import org.junit.jupiter.api.Test;
import ru.erminson.xo.models.exceptions.AlreadyOccupiedException;
import ru.erminson.xo.models.exceptions.InvalidPointException;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void getSize() {
        final Field field = new Field(3);
        assertEquals(3, field.getSize());
    }

    @Test
    void getFigure() {
    }

    @Test
    void setFigure() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;
        final Figure expectedFigure = inputFigure;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    void testGetFigureWhenFigureNotSet() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    void testGetFigureWhenXIsLessMinValue() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(-3,0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    void testGetFigureWhenYIsLessMinValue() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0,-2);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    void testGetFigureWhenXIsMoreMaxValue() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.getSize(),0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    void testGetFigureWhenYIsMoreMaxValue() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0,field.getSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }
}