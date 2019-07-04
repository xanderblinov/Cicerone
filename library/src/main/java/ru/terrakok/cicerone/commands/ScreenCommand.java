package ru.terrakok.cicerone.commands;

import ru.terrakok.cicerone.Screen;

public class ScreenCommand implements Command {

    private Screen screen;

    public ScreenCommand(final Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }
}
