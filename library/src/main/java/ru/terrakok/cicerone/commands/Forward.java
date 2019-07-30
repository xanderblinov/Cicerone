/*
 * Created by Konstantin Tskhovrebov (aka @terrakok)
 */

package ru.terrakok.cicerone.commands;

import ru.terrakok.cicerone.Screen;

/**
 * Opens new screen.
 */
public class Forward implements ScreenCommand {

    private Screen screen;

    public Forward(final Screen screen) {
        super();
        this.screen = screen;
    }

    @Override
    public Screen getScreen() {
        return screen;
    }
}
