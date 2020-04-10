package ru.erminson.xo.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getName() {
        final String inputValue = "Lev";
        final String expectedValue = inputValue;

        final Player player = new Player(inputValue, null);
        final String actualValue = player.getName();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getFigure() {
        final Figure inputValue = Figure.X;
        final Figure expectedValue = inputValue;

        final Player player = new Player(null, inputValue);
        final Figure actualValue = player.getFigure();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testToString() {
        final String inputNameValue = "Lev";
        final Figure inputFigureValue = Figure.X;

        final String expectedValue = "Player{" +
                "name='" + inputNameValue + '\'' +
                ", figure='" + inputFigureValue + '\'' +
                '}';


        final Player player = new Player(inputNameValue, inputFigureValue);
        String actualValue = player.toString();

        assertEquals(expectedValue, actualValue);
    }
}