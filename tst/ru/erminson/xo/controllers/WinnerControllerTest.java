package ru.erminson.xo.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.erminson.xo.models.Field;
import ru.erminson.xo.models.Figure;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WinnerControllerTest {

    Field field;
    int size;

    @BeforeEach
    void setUp() {
        field = new Field(3);
        size = field.getSize();
    }

    @AfterEach
    void tearDown() {
        field = null;
    }

    @Test
    void testGetWinnerWhenWinnerRow() throws Exception {
        final Figure inputFigure = Figure.X;
        final WinnerController winnerController = new WinnerController();
        final Figure expectedFigure = inputFigure;

        for (int i = 0; i < size; i++) {
            setUp();
            field.setFigure(new Point(i, 0), inputFigure);
            field.setFigure(new Point(i, 1), inputFigure);
            field.setFigure(new Point(i, 2), inputFigure);

            final Figure actualFigure = winnerController.getWinner(field);

            assertEquals(expectedFigure, actualFigure);
        }
    }

    @Test
    void testGetWinnerWhenNoWinnerRow() throws Exception {
        final Figure inputFigure = Figure.X;
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < size; i++) {
            setUp();
            field.setFigure(new Point(i, 0), inputFigure);
            field.setFigure(new Point(i, 1), inputFigure);
            field.setFigure(new Point(i, 2), Figure.O);

            final Figure actualFigure = winnerController.getWinner(field);

            assertNull(actualFigure);
        }
    }

    @Test
    void testGetWinnerWhenWinnerColumn() throws Exception {
        final Figure inputFigure = Figure.X;
        final WinnerController winnerController = new WinnerController();
        final Figure expectedFigure = inputFigure;

        for (int i = 0; i < size; i++) {
            setUp();
            field.setFigure(new Point(0, i), inputFigure);
            field.setFigure(new Point(1, i), inputFigure);
            field.setFigure(new Point(2, i), inputFigure);

            final Figure actualFigure = winnerController.getWinner(field);

            assertEquals(expectedFigure, actualFigure);
        }
    }

    @Test
    void testGetWinnerWhenNoWinnerColumn() throws Exception {
        final Figure inputFigure = Figure.X;
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < size; i++) {
            setUp();
            field.setFigure(new Point(0, i), inputFigure);
            field.setFigure(new Point(1, i), inputFigure);
            field.setFigure(new Point(2, i), Figure.O);

            final Figure actualFigure = winnerController.getWinner(field);

            assertNull(actualFigure);
        }
    }

    @Test
    void testGetWinnerWhenWinnerDiagonal1() throws Exception {
        final Figure inputFigure = Figure.X;
        final WinnerController winnerController = new WinnerController();
        final Figure expectedFigure = inputFigure;

        for (int i = 0; i < size; i++) {
            field.setFigure(new Point(i, i), inputFigure);
        }

        final Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    void testGetWinnerWhenNoWinnerDiagonal1() throws Exception {
        final Figure inputFigure = Figure.X;
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < size - 1; i++) {
            field.setFigure(new Point(i, i), inputFigure);
        }
        field.setFigure(new Point(size - 1, size - 1 ), Figure.O);

        final Figure actualFigure = winnerController.getWinner(field);

        assertNull(actualFigure);
    }

    @Test
    void testGetWinnerWhenWinnerDiagonal2() throws Exception {
        final Figure inputFigure = Figure.X;
        final WinnerController winnerController = new WinnerController();
        final Figure expectedFigure = inputFigure;

        final int size = field.getSize();
        for (int i = 0; i < size; i++) {
            field.setFigure(new Point(i,size - 1 - i), inputFigure);
        }

        final Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    void testGetWinnerWhenNoWinnerDiagonal2() throws Exception {
        final Figure inputFigure = Figure.X;
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < size - 1; i++) {
            field.setFigure(new Point(i,size - 1 - i), inputFigure);
        }
        field.setFigure(new Point(size - 1, 0), Figure.O);

        final Figure actualFigure = winnerController.getWinner(field);

        assertNull(actualFigure);
    }
}