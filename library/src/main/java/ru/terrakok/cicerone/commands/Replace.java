/*
 * Created by Konstantin Tskhovrebov (aka @terrakok)
 */

package ru.terrakok.cicerone.commands;

import ru.terrakok.cicerone.Screen;

/**
 * Replaces the current screen.
 */
public class Replace implements ScreenCommand {

    private Screen screen;

    public Replace(final Screen screen) {
        super();
        this.screen = screen;
    }

    @Override
    public Screen getScreen() {
        return screen;
    }
}