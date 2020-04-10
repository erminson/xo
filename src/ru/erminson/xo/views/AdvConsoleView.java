package ru.erminson.xo.views;

import ru.erminson.xo.models.Game;

public class AdvConsoleView extends ConsoleView {

    public AdvConsoleView(Game game) {
        super(game);
    }

    @Override
    public void showGameName() {
        printLine();
        super.showGameName();
        printLine();
    }

    private void printLine() {
        System.out.println("***");
    }
}
