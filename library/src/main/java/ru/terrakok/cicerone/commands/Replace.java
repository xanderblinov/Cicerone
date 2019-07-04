/*
 * Created by Konstantin Tskhovrebov (aka @terrakok)
 */

package ru.terrakok.cicerone.commands;

import ru.terrakok.cicerone.Screen;

/**
 * Replaces the current screen.
 */
public class Replace extends ScreenCommand{

    public Replace(final Screen screen) {
        super(screen);
    }
}
